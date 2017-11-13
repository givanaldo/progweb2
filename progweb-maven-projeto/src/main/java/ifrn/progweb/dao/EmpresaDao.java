package ifrn.progweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ifrn.progweb.model.Empresa;

public class EmpresaDao {

	private EntityManager manager;

	public EmpresaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adicionar(Empresa empresa) {
		manager.getTransaction().begin();
		manager.persist(empresa);
		manager.getTransaction().commit();
	}
	
	public Empresa pesquisarPorId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public void remover(Empresa empresa) {
		empresa = pesquisarPorId(empresa.getId());
		manager.getTransaction().begin();
		manager.remove(empresa);
		manager.getTransaction().commit();
	}
	
	public List<Empresa> pesquisar(String nomeFantasia) {
		TypedQuery<Empresa> consulta = manager.createQuery(
				"from Empresa where nomeFantasia like :nomeFantasia", 
				Empresa.class);
		consulta.setParameter("nomeFantasia", nomeFantasia + "%");
		return consulta.getResultList();
	}
	
	
}
