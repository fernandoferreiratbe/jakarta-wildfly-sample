package io.github.fernandoferreira.job;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import io.github.fernandoferreira.entidade.AgendamentoEmail;
import io.github.fernandoferreira.servico.AgendamentoEmailServico;

@Stateless
public class AgendamentoEmailJob {
	
	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void enviarEmail() {
		List<AgendamentoEmail> listaPorNaoAgendado = this.agendamentoEmailServico.listarPorNaoAgendado();
		
		listaPorNaoAgendado.forEach(email -> {
			this.agendamentoEmailServico.enviar(email);
			this.agendamentoEmailServico.alterar(email);
		});
	}

}
