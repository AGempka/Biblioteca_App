/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Autor;
import entity.Libros;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import model.AutorFacadeLocal;
import model.LibrosFacadeLocal;

/**
 *
 * @author user
 */
@Named(value = "librosBean")
@SessionScoped
public class LibrosBean implements Serializable{

   
    
    @EJB
    private LibrosFacadeLocal librosFacade;

    @EJB
    private AutorFacadeLocal autorFacade;
    private Libros libros;
    private Autor autor;
  
  public LibrosBean() {
  libros = new Libros();
  autor = new Autor();  
  }


   public List<Libros> getLibroses(){
    return librosFacade.findAll();
    }
  
    public List<Autor> getAutors(){
    return autorFacade.findAll();
    }
    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
        this.autor=libros.getIdAutor();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
        
    }

   public void grabar(){
    libros.setIdAutor(autor);
    if(libros.getIsbn()==null){
        librosFacade.create(libros);
    }else{
        librosFacade.edit(libros);}
    libros=new Libros();
    autor = new Autor();
    }
    
    public void delete(Libros l){
   if(l.getIsbn()!=null){}
        librosFacade.remove(l);
    }
    
    
}
