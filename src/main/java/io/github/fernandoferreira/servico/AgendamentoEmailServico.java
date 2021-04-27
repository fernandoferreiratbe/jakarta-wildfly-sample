package io.github.fernandoferreira.servico;

import java.util.List;

import javax.ejb.Stateless;

/* Stateless indica que n�o queremos guardar estado desta classe/objeto.
 * A cada requisi��o do usu�rio devera ser oferecida uma nova inst�ncia
 */
@Stateless 
public class AgendamentoEmailServico {
	
	public List<String> listar() {
		return List.of("joao@me.com.br", "maria@me.com.br");
	}

}
