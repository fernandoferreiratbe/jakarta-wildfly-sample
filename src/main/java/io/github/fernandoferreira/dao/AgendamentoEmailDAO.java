package io.github.fernandoferreira.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import io.github.fernandoferreira.entidade.AgendamentoEmail;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AgendamentoEmailDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private UserTransaction userTransaction;
	
	public List<AgendamentoEmail> listar() {
		return this.entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae", AgendamentoEmail.class).getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		this.entityManager.persist(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return this.entityManager
				.createQuery("SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado = false", AgendamentoEmail.class)
				.getResultList();
	}
	
	public void alterar(AgendamentoEmail agendamentoEmail) {
		try {
			this.userTransaction.begin();
			this.entityManager.merge(agendamentoEmail);
			this.userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
