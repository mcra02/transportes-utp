/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Departamento;
import Servicios.DepartamentoServicio;
import Servicios.DepartamentoServicioLocal;
import Servicios.ProvinciaServicioLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;

/**
 *
 * @author Maicol Rodrigo
 */
@Named(value = "departamentos")
@SessionScoped
public class Departamentos implements Serializable {

    @EJB
    private DepartamentoServicioLocal departamentoServicio;

    private Departamento dep = new Departamento();

    /**
     * Creates a new instance of Departamentos
     */
    public Departamentos() {
    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }

    public List<Departamento> getAll() {
        List<Departamento> lista = null;
        try {
            lista = this.departamentoServicio.getAll();
        } catch (EJBException ex) {
            System.out.println(ex.getCause());
        }
        return lista;
    }

    public String add() {
        this.departamentoServicio.crear(this.dep);
        this.dep = new Departamento();
        return "index";
    }

    public void delete(Departamento dep) {
        this.departamentoServicio.eliminar(dep);
    }

    public String edit(Departamento dep) {
        this.departamentoServicio.actualizar(dep);
        return "edit";
    }

    public String edit() {
        this.departamentoServicio.actualizar(this.dep);
        this.dep = new Departamento();
        return "index";
    }

}
