/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Autor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import model.AutorFacadeLocal;

/**
 *
 * @author user
 */
@Named(value = "autoresBean")
@SessionScoped
public class AutoresBean implements Serializable {

    @EJB
    private AutorFacadeLocal autorFacade;
    private Autor nombre_autor;
    
     public List<Autor> getAutors(){
    return autorFacade.findAll();
    }

    public AutoresBean() {
        nombre_autor= new Autor();
    }
    
    public void grabar(){
         if(nombre_autor.getIdAutor()==null){
            autorFacade.create(nombre_autor);
        }else{
            autorFacade.edit(nombre_autor);
        }
        nombre_autor= new Autor();
    }
    
    public void delete(Autor a){
    if(a.getIdAutor()!=null){
    autorFacade.remove(a);}
    }

    public Autor getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(Autor nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    
}
