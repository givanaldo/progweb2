package ifrn.progweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ifrn.progweb.model.Empresa;

public class EmpresaDao {

	@Inject
	private EntityManager manager;

	public EmpresaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public Empresa adicionar(Empresa empresa) {
		// manager.getTransaction().begin(); -- não é mais necessário
		return manager.merge(empresa);
		// manager.getTransaction().commit();
	}
	
	public Empresa pesquisarPorId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public void remover(Empresa empresa) {
		empresa = pesquisarPorId(empresa.getId());
		// manager.getTransaction().begin();
		manager.remove(empresa);
		// manager.getTransaction().commit();
	}
	
	public List<Empresa> pesquisar(String nomeFantasia) {
		TypedQuery<Empresa> consulta = manager.createQuery(
				"from Empresa where nomeFantasia like :nomeFantasia", 
				Empresa.class);
		consulta.setParameter("nomeFantasia", nomeFantasia + "%");
		return consulta.getResultList();
	}
	
	
}
