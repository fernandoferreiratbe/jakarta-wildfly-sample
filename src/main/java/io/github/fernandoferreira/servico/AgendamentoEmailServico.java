package io.github.fernandoferreira.servico;

import java.util.List;

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
	
	public List<AgendamentoEmail> listar() {
		return dao.listar();
	}
}
