package io.github.fernandoferreira.job;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import io.github.fernandoferreira.entidade.AgendamentoEmail;
import io.github.fernandoferreira.servico.AgendamentoEmailServico;

@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AgendamentoEmailJob {
	
	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;
	
	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext context;
	
	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void enviarEmail() {
		List<AgendamentoEmail> listaPorNaoAgendado = this.agendamentoEmailServico.listarPorNaoAgendado();
		
		listaPorNaoAgendado.forEach(email -> {
			this.context.createProducer().send(queue, email);
			this.agendamentoEmailServico.alterar(email);
		});
	}

}
