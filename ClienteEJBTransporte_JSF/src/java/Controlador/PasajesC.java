/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Pasajes;
import Servicios.PasajesServicioLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Maicol Rodrigo
 */
@Named(value = "pasajesC")
@SessionScoped
public class PasajesC implements Serializable {

    @EJB
    private PasajesServicioLocal pasajesServicio;

    private Pasajes pas = new Pasajes();

    public Pasajes getPas() {
        return pas;
    }

    public void setPas(Pasajes pas) {
        this.pas = pas;
    }
    
    
    /**
     * Creates a new instance of PasajesC
     */
    public PasajesC() {
    }
    public List<Pasajes> getAll(){
        List<Pasajes> lista = this.pasajesServicio.getAll();
        return lista;
    }
    public String add(){
        this.pasajesServicio.crear(this.pas);
        this.pas = new Pasajes();
        return "index";
    }
    public void delete(Pasajes pas){
        this.pasajesServicio.eliminar(pas);
    }
    public String edit(Pasajes dis){
        this.pasajesServicio.actualizar(pas);
        return "edit";
    }
    public String edit(){
        this.pasajesServicio.actualizar(this.pas);
        this.pas = new Pasajes();
        return "index";
    }
}
