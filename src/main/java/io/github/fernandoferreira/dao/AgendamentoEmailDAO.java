package io.github.fernandoferreira.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.github.fernandoferreira.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final String SELECT_AGENDAMENTO_EMAIL = "SELECT ae FROM AgendamentoEmail ae";
	
	public List<AgendamentoEmail> listar() {
		return this.entityManager.createQuery(SELECT_AGENDAMENTO_EMAIL, AgendamentoEmail.class).getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		this.entityManager.persist(agendamentoEmail);
	}
}
