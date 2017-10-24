package view;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.JpaUtil;
import model.TotalCarroPorAno;
import model.Veiculo;

public class TestJpql {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		/*
		// Consulta tipada com parâmetros
		TypedQuery<Veiculo> queryVeiculo = 
				manager.createQuery("from Veiculo where anoModelo >= :ano and valor <= :preco", Veiculo.class);
		queryVeiculo.setParameter("ano", 2009);
		queryVeiculo.setParameter("preco", new BigDecimal(30_000));
		List<Veiculo> veiculos = queryVeiculo.getResultList();
		for (Veiculo v : veiculos) {
			System.out.println(v.getCodigo() + " - " + v.getFabricante() + " " + 
		                       v.getModelo() + " (" + v.getAnoModelo() + "): R$ " + 
		                       v.getValor() + " - Proprietário: " + v.getProprietario().getNome());
		}
		
		// Projeções
		TypedQuery<String> queryProprietario = manager.createQuery("select nome from Proprietario", String.class);
		List<String> proprietarios = queryProprietario.getResultList();
		for (String p : proprietarios) {
			System.out.println(p);
		}
		
		TypedQuery<Object[]> queryValores = manager.createQuery("select modelo, valor from Veiculo", Object[].class);
		List<Object[]> valores = queryValores.getResultList();
		for (Object[] resultado : valores) {
			String modelo = (String) resultado[0];
			BigDecimal valor = (BigDecimal) resultado[1];
			System.out.println(modelo + ": R$ " + valor);
		}
		*/
		// Funções de agregação
		TypedQuery<TotalCarroPorAno> queryTotal = 
				manager.createQuery("select new model.TotalCarroPorAno(v.anoFabricacao, "
						+ "avg(v.valor), count(v)) from Veiculo v " 
						+ "group by v.anoFabricacao", TotalCarroPorAno.class);
		List<TotalCarroPorAno> resultado = queryTotal.getResultList();
		for (TotalCarroPorAno v : resultado) {
			System.out.println("Ano: " + v.getAnoFabricacao() + 
							   " - Preço médio: R$ " + v.getMediaPreco() + 
							   " - Quantidade: " + v.getQuantidadeCarros());
		}
		
		TypedQuery<Long> queryTotalVeiculos = 
				manager.createQuery("select count(v) from Veiculo v", Long.class);
		Long totalVeiculos = queryTotalVeiculos.getSingleResult();
		System.out.println("Total de veículos: " + totalVeiculos);
		
	}

}
