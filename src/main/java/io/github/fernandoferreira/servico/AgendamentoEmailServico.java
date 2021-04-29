package io.github.fernandoferreira.servico;

import java.util.List;

import javax.ejb.Stateless;

import io.github.fernandoferreira.dao.AgendamentoEmailDAO;
import io.github.fernandoferreira.entidade.AgendamentoEmail;

/* Stateless indica que n�o queremos guardar estado desta classe/objeto.
 * A cada requisi��o do usu�rio devera ser oferecida uma nova inst�ncia
 */
@Stateless 
public class AgendamentoEmailServico {
	
	public List<AgendamentoEmail> listar() {
		AgendamentoEmailDAO dao = new AgendamentoEmailDAO();
		
		return dao.listar();
	}

}
