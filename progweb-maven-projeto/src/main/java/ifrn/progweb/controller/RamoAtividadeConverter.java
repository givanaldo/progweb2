package ifrn.progweb.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ifrn.progweb.model.RamoAtividade;

public class RamoAtividadeConverter implements Converter {

	private List<RamoAtividade> listaRamoAtividades;

    public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividades) {
        this.listaRamoAtividades = listaRamoAtividades;
    }
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null)
            return null;
        
        Long id = Long.valueOf(arg2);
        
        for (RamoAtividade ramoAtividade: listaRamoAtividades)
            if (id.equals(ramoAtividade.getId()))
                return ramoAtividade;
        
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null)
            return null;
        
        RamoAtividade ramoAtividade = (RamoAtividade) arg2;
        
        return ramoAtividade.getId().toString();
	}

}
