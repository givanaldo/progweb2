package ifrn.progweb.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ifrn.progweb.model.Empresa;

public class EmpresaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public EmpresaDao() {

	}

	public EmpresaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public Empresa adicionar(Empresa empresa) {
		// manager.getTransaction().begin(); -- não é mais necessário
		return manager.merge(empresa);
		// manager.getTransaction().commit(); -- não é mais necessário
	}
	
	public Empresa pesquisarPorId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public void remover(Empresa empresa) {
		empresa = pesquisarPorId(empresa.getId());
		manager.remove(empresa);
	}
	
	public List<Empresa> pesquisar(String nomeFantasia) {
		TypedQuery<Empresa> consulta = manager.createQuery(
				"from Empresa where nomeFantasia like :nomeFantasia", 
				Empresa.class);
		consulta.setParameter("nomeFantasia", nomeFantasia + "%");
		return consulta.getResultList();
	}
	
	public List<Empresa> todas() {
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
   }
}
