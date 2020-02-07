/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import Entidad.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author maicol
 */
public interface IClienteDAO extends IGenericoDAO<Cliente, Serializable>{
    public List<Cliente> getAll();
}
