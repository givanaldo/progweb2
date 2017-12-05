package ifrn.progweb.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import ifrn.progweb.dao.EmpresaDao;
import ifrn.progweb.dao.RamoAtividadeDao;
import ifrn.progweb.model.Empresa;
import ifrn.progweb.model.RamoAtividade;
import ifrn.progweb.model.TipoEmpresa;
import ifrn.progweb.service.CadastroEmpresaService;
import ifrn.progweb.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    @Inject
    private EmpresaDao empresas;
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private RamoAtividadeDao ramoAtividades;
    
    @Inject
    private CadastroEmpresaService cadastroEmpresaService;

    private Empresa empresa;
    
    private List<Empresa> listaEmpresas;

    private String termoPesquisa;
    
    private Converter ramoAtividadeConverter;
    
    public void pesquisar() {
        listaEmpresas = empresas.pesquisar(termoPesquisa);
        
        if (listaEmpresas.isEmpty()) {
            messages.info("Sua consulta não retornou registros.");
        }
    }
    
	public void todasEmpresas() {
        listaEmpresas = empresas.todas();
    }
	
	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		 
		// verificar se usuario disparou uma pesquisa e refazer a mesma.
		if (houvePesquisa())
			pesquisar();
		else
			todasEmpresas();
		
		messages.info("Empresa salva com sucesso!");
		
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:messages", "frm:empresasDataTable"));
	}
	
	private boolean houvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}
	
	public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        
        return listaRamoAtividades;
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
    
    public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

    public TipoEmpresa[] getTiposEmpresa() {
    		return TipoEmpresa.values();
    }
    
    public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
    
    public Empresa getEmpresa() {
		return empresa;
	}
    
    public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
    
    public boolean isEmpresaSelecionada() {
    		return empresa != null && empresa.getId() != null;
    }
}
