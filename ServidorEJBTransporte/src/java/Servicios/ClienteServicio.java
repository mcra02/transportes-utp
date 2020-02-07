/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.ClienteDAO;
import Entidad.Cliente;
import InterfaceDAO.IClienteDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Maicol Rodrigo
 */
@Stateless
public class ClienteServicio implements ClienteServicioLocal {

    private IClienteDAO clienteDAO;

    public ClienteServicio() {
        clienteDAO = new ClienteDAO();
    }
    
    @Override
    public List<Cliente> getAll() {
        List<Cliente> clientes = clienteDAO.getAll();
        return clientes;
    }

    @Override
    public Cliente getById(Serializable id) {
        Cliente cliente = clienteDAO.getById(id);
        return cliente;
    }

    @Override
    public void crear(Cliente cli) {
        clienteDAO.crear(cli);
    }

    @Override
    public void actualizar(Cliente cli) {
        clienteDAO.actualizar(cli);
    }

    @Override
    public void eliminar(Cliente cli) {
        clienteDAO.eliminar(cli);
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
