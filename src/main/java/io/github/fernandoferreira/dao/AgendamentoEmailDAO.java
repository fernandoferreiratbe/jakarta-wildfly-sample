package io.github.fernandoferreira.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.github.fernandoferreira.entidade.AgendamentoEmail;

public class AgendamentoEmailDAO {

	private EntityManager entityManager;
	
	private final String PERSISTENCE_UNIT_NAME = "AgendamentoEmailDS";
	private final String SELECT_AGENDAMENTO_EMAIL = "SELECT ae FROM agendamentoemail ae";
	
	public AgendamentoEmailDAO() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(this.PERSISTENCE_UNIT_NAME);
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public List<AgendamentoEmail> listar() {
		this.entityManager.getTransaction().begin();
		List<AgendamentoEmail> agendamentos = this.entityManager.createQuery(SELECT_AGENDAMENTO_EMAIL, AgendamentoEmail.class).getResultList();
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
		return agendamentos;
	}
}
