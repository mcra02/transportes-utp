/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Rutas;
import Servicios.RutasServicioLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Maicol Rodrigo
 */
@Named(value = "rutass")
@SessionScoped
public class Rutass implements Serializable {

    @EJB
    private RutasServicioLocal rutasServicio;

    private Rutas ruta = new Rutas();

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }
    
    
    /**
     * Creates a new instance of Rutass
     */
    public Rutass() {
    }
    public List<Rutas> getAll() {
        List<Rutas> lista = null;
        try {
            lista = this.rutasServicio.getAll();
        } catch (EJBException ex) {
            System.out.println(ex.getCause());
        }
        return lista;
    }

    public String add() {
        this.rutasServicio.crear(this.ruta);
        this.ruta = new Rutas();
        return "index";
    }

    public void delete(Rutas ruta) {
        this.rutasServicio.eliminar(ruta);
    }

    public String edit(Rutas ruta) {
        this.rutasServicio.actualizar(ruta);
        return "edit";
    }

    public String edit() {
        this.rutasServicio.actualizar(this.ruta);
        this.ruta = new Rutas();
        return "index";
    }
}
