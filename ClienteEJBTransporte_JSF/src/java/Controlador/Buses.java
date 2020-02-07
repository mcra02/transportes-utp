/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Bus;
import Servicios.BusServicioLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author maicol
 */
@Named(value = "buses")
@SessionScoped
public class Buses implements Serializable {

    @EJB
    private BusServicioLocal busServicio;

    private Bus bus = new Bus();

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    
    /**
     * Creates a new instance of Buses
     */
    public Buses() {
    }
    
    public List<Bus> getAll(){
        List<Bus> lista = this.busServicio.getAll();
        return lista;
    }
    public String add(){
        this.busServicio.crear(this.bus);
        this.bus = new Bus();
        return "index";
    }
    public void delete(Bus bus){
        this.busServicio.eliminar(bus);
    }
    public String edit(Bus bus){
        this.busServicio.actualizar(bus);
        return "edit";
    }
    public String edit(){
        this.busServicio.actualizar(this.bus);
        this.bus = new Bus();
        return "index";
    }
}
