package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Proprietario;

public class ProprietarioDao implements Serializable {
	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	public ProprietarioDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public Proprietario pesquisaPorId(Long id) {
		return manager.find(Proprietario.class, id);
	}
	
	public void adicionar(Proprietario proprietario) {
		manager.getTransaction().begin();
		manager.persist(proprietario);
		manager.getTransaction().commit();
	}
	
	public void remover(Proprietario proprietario) {
		proprietario = pesquisaPorId(proprietario.getId());
		manager.getTransaction().begin();
		manager.remove(proprietario);
		manager.getTransaction().commit();
	}
	
	public List<Proprietario> pesquisar(String nome) {
		TypedQuery<Proprietario> consulta = 
				manager.createQuery("from Proprietario where nome like :nome", Proprietario.class);
		consulta.setParameter("nome", nome + "%");
		return consulta.getResultList();
	}

}
