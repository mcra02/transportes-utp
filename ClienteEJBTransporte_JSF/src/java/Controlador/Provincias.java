/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Provincia;
import Servicios.ProvinciaServicioLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Maicol Rodrigo
 */
@Named(value = "provincias")
@SessionScoped
public class Provincias implements Serializable {

    @EJB
    private ProvinciaServicioLocal provinciaServicio;

    
    
    private Provincia pro = new Provincia();

    public Provincia getPro() {
        return pro;
    }

    public void setPro(Provincia pro) {
        this.pro = pro;
    }
    
    /**
     * Creates a new instance of Provincias
     */
    public Provincias() {
    }
    
    public List<Provincia> getAll(){
        List<Provincia> lista = this.provinciaServicio.getAll();       
        return lista;
    }
    public String add(){
        this.provinciaServicio.crear(this.pro);
        this.pro = new Provincia();
        return "index";
    }
    public void delete(Provincia dep){
        this.provinciaServicio.eliminar(dep);
    }
    public String edit(Provincia dep){
        this.provinciaServicio.actualizar(dep);
        return "edit";
    }
    public String edit(){
        this.provinciaServicio.actualizar(this.pro);
        this.pro = new Provincia();
        return "index";
    }
    
}
