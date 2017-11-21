package ifrn.progweb.service;

import java.io.Serializable;

import javax.inject.Inject;

import ifrn.progweb.model.Empresa;
import ifrn.progweb.dao.EmpresaDao;
import ifrn.progweb.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaDao empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.adicionar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}
