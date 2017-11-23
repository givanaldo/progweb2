package ifrn.progweb.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ifrn.progweb.model.Empresa;
import ifrn.progweb.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Empresa empresa = new Empresa();
    
    public Empresa getEmpresa() {
		return empresa;
	}
    
    public TipoEmpresa[] getTiposEmpresa() {
    		return TipoEmpresa.values();
    }
    
    public void salvar() {
    		System.out.println("Razão social: " + empresa.getRazaoSocial() +
    				" - Nome de fantasia: " + empresa.getNomeFantasia() +
    				" - Tipo: " + empresa.getTipo());
    }
    
    public String ajuda() {
        return "AjudaGestaoEmpresasV5?faces-redirect=true";
    }
}