package ifrn.progweb.controller;

import java.io.Serializable;

//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
//@RequestScoped
//@SessionScoped
//@ApplicationScoped
public class _GestaoEmpresasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static Integer NUMERO = 0;
    
    public _GestaoEmpresasBean() {
        NUMERO++;
    }
    
    public Integer getNumero() {
        return NUMERO;
    }
}