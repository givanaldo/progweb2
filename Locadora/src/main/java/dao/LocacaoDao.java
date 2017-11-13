package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Locacao;

public class LocacaoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	public LocacaoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public Locacao pesquisarPoId(Long id) {
		return manager.find(Locacao.class, id);
	}
	
	public void adicionar(Locacao locacao) {
		manager.getTransaction().begin();
		manager.persist(locacao);
		manager.getTransaction().commit();
	}
	
	public void remover(Locacao locacao) {
		locacao = pesquisarPoId(locacao.getId());
		manager.getTransaction().begin();
		manager.remove(locacao);
		manager.getTransaction().commit();
	}
	
	public List<Locacao> pesquisar() {
		TypedQuery<Locacao> consulta = 
				manager.createQuery("from Locacao", Locacao.class);
		return consulta.getResultList();
	}
}
