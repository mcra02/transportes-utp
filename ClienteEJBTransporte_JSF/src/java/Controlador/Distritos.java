/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Distrito;
import Servicios.DistritoServicioLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author maicol
 */
@Named(value = "distrito")
@SessionScoped
public class Distritos implements Serializable {

    @EJB
    private DistritoServicioLocal distritoServicio;
    
    private Distrito dis = new Distrito();

    public Distrito getDis() {
        return dis;
    }

    public void setDis(Distrito dis) {
        this.dis = dis;
    }

    

    
    /**
     * Creates a new instance of Distrito
     */
    public Distritos() {
    }
    
    public List<Distrito> getAll(){
        List<Distrito> lista = this.distritoServicio.getAll();
        return lista;
    }
    public String add(){
        this.distritoServicio.crear(this.dis);
        this.dis = new Distrito();
        return "index";
    }
    public void delete(Distrito dis){
        this.distritoServicio.eliminar(dis);
    }
    public String edit(Distrito dis){
        this.distritoServicio.actualizar(dis);
        return "edit";
    }
    public String edit(){
        this.distritoServicio.actualizar(this.dis);
        this.dis = new Distrito();
        return "index";
    }
}
