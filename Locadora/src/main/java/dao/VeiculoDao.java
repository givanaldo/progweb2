package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Veiculo;

public class VeiculoDao implements Serializable {
	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	public VeiculoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public Veiculo pesquisaPorId(Long id) {
		return manager.find(Veiculo.class, id);
	}
	
	public void adicionar(Veiculo veiculo) {
		manager.getTransaction().begin();
		manager.persist(veiculo);
		manager.getTransaction().commit();
	}
	
	public void remover(Veiculo veiculo) {
		veiculo = pesquisaPorId(veiculo.getId());
		manager.getTransaction().begin();
		manager.remove(veiculo);
		manager.getTransaction().commit();
	}
	
	public List<Veiculo> pesquisar(String modelo) {
		TypedQuery<Veiculo> consulta = 
				manager.createQuery("from Veiculo where modelo like :modelo", Veiculo.class);
		consulta.setParameter("modelo", modelo + "%");
		return consulta.getResultList();
	}
}
