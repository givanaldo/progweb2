package ifrn.progweb.view;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ifrn.progweb.dao.EmpresaDao;
import ifrn.progweb.dao.RamoAtividadeDao;
import ifrn.progweb.model.Empresa;
import ifrn.progweb.model.JpaUtil;
import ifrn.progweb.model.RamoAtividade;
import ifrn.progweb.model.TipoEmpresa;



public class TesteBanco {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		RamoAtividadeDao ativDao = new RamoAtividadeDao(manager);
		EmpresaDao emprDao = new EmpresaDao(manager);

		List<RamoAtividade> listaAtiv = ativDao.pesquisar("");
		System.out.println("\n\n=== Atividades ===");
		for (RamoAtividade atividade : listaAtiv)
			System.out.println(atividade);
		
		// inserir uma atividade
		RamoAtividade novaAtividade = new RamoAtividade();
		novaAtividade.setDescricao("Tecnologia da Informação");
		manager.getTransaction().begin();
		ativDao.adicionar(novaAtividade);
		manager.getTransaction().commit();
		
		listaAtiv = ativDao.pesquisar("");
		System.out.println("\n\n=== Atividades ===");
		for (RamoAtividade atividade : listaAtiv)
			System.out.println(atividade);
		
		listaAtiv = ativDao.pesquisar("te");
		System.out.println("\n\n=== Atividades ===");
		for (RamoAtividade atividade : listaAtiv)
			System.out.println(atividade);

		RamoAtividade ativ = ativDao.pesquisarPorId(3L);
    	System.out.println("\n\n" + ativ);

	
		List<Empresa> listaEmpr = emprDao.pesquisar("");
		for (Empresa empresa : listaEmpr)
			System.out.println(empresa.toString());
		
		// inserir uma empresa
		Empresa novaEmpresa = new Empresa();
		novaEmpresa.setNomeFantasia("João da Silva");
		novaEmpresa.setCnpj("41.952.519/0001-57");
		novaEmpresa.setRazaoSocial("João da Silva 41952519000157");
		novaEmpresa.setTipo(TipoEmpresa.MEI);
		novaEmpresa.setDataFundacao(new Date());
		novaEmpresa.setRamoAtividade(ativDao.pesquisarPorId(5L));
		emprDao.adicionar(novaEmpresa);
		
		listaEmpr = emprDao.pesquisar("");
		for (Empresa empresa : listaEmpr)
			System.out.println(empresa.toString());
		
		Empresa empresaExcluir = new Empresa();
		empresaExcluir.setId(3L);		
		emprDao.remover(empresaExcluir);

		listaEmpr = emprDao.pesquisar("");
		for (Empresa empresa : listaEmpr)
			System.out.println(empresa.toString());

		manager.close();
	}
}
