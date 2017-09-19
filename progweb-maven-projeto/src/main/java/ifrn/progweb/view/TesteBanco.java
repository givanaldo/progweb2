package ifrn.progweb.view;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ifrn.progweb.model.Empresa;
import ifrn.progweb.model.JpaUtil;
import ifrn.progweb.model.RamoAtividade;
import ifrn.progweb.model.TipoEmpresa;



public class TesteBanco {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();

		Query consulta = manager.createQuery("from Empresa", Empresa.class); 
		List<Empresa> listaEmpresas = consulta.getResultList();
		for (Empresa empresa : listaEmpresas)
			System.out.println(empresa.toString());
		
		consulta = manager.createQuery("from RamoAtividade", RamoAtividade.class);
		List<RamoAtividade> listaAtividades = consulta.getResultList();
		System.out.println("\n\n=== Atividades ===");
		for (RamoAtividade atividade : listaAtividades)
			System.out.println(atividade.toString());
		
		// inserir uma atividade
		RamoAtividade novaAtividade = new RamoAtividade();
		novaAtividade.setDescricao("Tecnologia da Informação");
		manager.getTransaction().begin();
		manager.persist(novaAtividade);
		manager.getTransaction().commit();
		
		consulta = manager.createQuery("from RamoAtividade", RamoAtividade.class);
		listaAtividades = consulta.getResultList();
		System.out.println("\n\n=== Atividades ===");
		for (RamoAtividade atividade : listaAtividades)
			System.out.println(atividade.toString());

		// inserir uma empresa
		Empresa novaEmpresa = new Empresa();
		novaEmpresa.setNomeFantasia("João da Silva");
		novaEmpresa.setCnpj("41.952.519/0001-57");
		novaEmpresa.setRazaoSocial("João da Silva 41952519000157");
		novaEmpresa.setTipo(TipoEmpresa.MEI);
		novaEmpresa.setDataFundacao(new Date());
		novaEmpresa.setRamoAtividade(listaAtividades.get(4));
		manager.getTransaction().begin();
		manager.persist(novaEmpresa);
		manager.getTransaction().commit();
		
		consulta = manager.createQuery("from Empresa", Empresa.class); 
		listaEmpresas = consulta.getResultList();
		for (Empresa empresa : listaEmpresas)
			System.out.println(empresa.toString());
		
		manager.close();
	}
}
