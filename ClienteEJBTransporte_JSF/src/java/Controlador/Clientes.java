/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Cliente;
import Servicios.ClienteServicioLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author maicol
 */
@Named(value = "clientes")
@SessionScoped
public class Clientes implements Serializable {

    @EJB
    private ClienteServicioLocal clienteServicio;

    private Cliente cli = new Cliente();

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    
    /**
     * Creates a new instance of Clientes
     */
    public Clientes() {
    }
    public List<Cliente> getAll(){
        List<Cliente> lista = this.clienteServicio.getAll();
        return lista;
    }
    public String add(){
        this.clienteServicio.crear(this.cli);
        this.cli = new Cliente();
        return "index";
    }
    public void delete(Cliente cli){
        this.clienteServicio.eliminar(cli);
    }
    public String edit(Cliente cli){
        this.clienteServicio.actualizar(cli);
        return "edit";
    }
    public String edit(){
        this.clienteServicio.actualizar(this.cli);
        this.cli = new Cliente();
        return "index";
    }
}
