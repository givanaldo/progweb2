package view;

import javax.persistence.EntityManager;

import dao.LocacaoDao;
import dao.ProprietarioDao;
import dao.VeiculoDao;
import model.JpaUtil;
import model.Locacao;
import model.Proprietario;
import model.Veiculo;

public class TesteLocadora {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
	
		VeiculoDao veiculoDao = new VeiculoDao(manager);
		for (Veiculo v : veiculoDao.pesquisar("")) {
			System.out.println(v);
		}
		
		System.out.println("");
		
		ProprietarioDao proprietarioDao = new ProprietarioDao(manager);
		for (Proprietario p : proprietarioDao.pesquisar("")) {
			System.out.println(p);
		}
		
		System.out.println("");
		
		LocacaoDao locacaoDao = new LocacaoDao(manager);
		for (Locacao l : locacaoDao.pesquisar()) {
			System.out.println(l);
		}
	}

}
