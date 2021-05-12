package io.github.fernandoferreira.servico;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import io.github.fernandoferreira.dao.AgendamentoEmailDAO;
import io.github.fernandoferreira.entidade.AgendamentoEmail;

/* Stateless indica que nao queremos guardar estado desta classe/objeto.
 * A cada requisicao do usuario devera ser oferecida uma nova instancia
 */
@Stateless 
public class AgendamentoEmailServico {
	
	@Inject
	private AgendamentoEmailDAO dao;
	
	private final Logger LOGGER = Logger.getLogger(AgendamentoEmailServico.class.getName());
	
	public List<AgendamentoEmail> listar() {
		return this.dao.listar();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		this.dao.inserir(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return this.dao.listarPorNaoAgendado();
	}
	
	public void alterar(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(true);
		
		this.dao.alterar(agendamentoEmail);
	}
	
	public void enviar(AgendamentoEmail agendamentoEmail) {
		try {
			Thread.sleep(5000);
			this.LOGGER.info("O e-mail do(a) usuário(a) " + agendamentoEmail.getEmail() + " foi enviado.");
		} catch (Exception e){
			this.LOGGER.warning(e.getMessage());
		}
	}
}
