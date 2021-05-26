package io.github.fernandoferreira.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AgendamentoEmail implements Serializable {

	private static final long serialVersionUID = -1193358969750727170L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String assunto;
	
	private String mensagem;
	
	private Boolean agendado;
	
}
