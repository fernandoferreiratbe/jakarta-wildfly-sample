package io.github.fernandoferreira.servico;

import java.util.List;

import javax.ejb.Stateless;

/* Stateless indica que não queremos guardar estado desta classe/objeto.
 * A cada requisição do usuário devera ser oferecida uma nova instância
 */
@Stateless 
public class AgendamentoEmailServico {
	
	public List<String> listar() {
		return List.of("joao@me.com.br", "maria@me.com.br");
	}

}
