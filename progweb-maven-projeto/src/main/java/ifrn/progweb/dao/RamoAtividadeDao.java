package ifrn.progweb.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ifrn.progweb.model.RamoAtividade;

public class RamoAtividadeDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public RamoAtividadeDao() {

	}

	public RamoAtividadeDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adicionar(RamoAtividade atividade) {
		manager.persist(atividade);
	}
	
	public RamoAtividade pesquisarPorId(Long id) {
		return manager.find(RamoAtividade.class, id);
	}
	
	public void remover(RamoAtividade atividade) {
		atividade = pesquisarPorId(atividade.getId());
		manager.remove(atividade);
	}
	
	public List<RamoAtividade> pesquisar(String descricao) {
		TypedQuery<RamoAtividade> consulta = manager.createQuery(
				"from RamoAtividade where descricao like :descricao", 
				RamoAtividade.class);
		consulta.setParameter("descricao", descricao + "%");
		return consulta.getResultList();
	}
	
	
}
