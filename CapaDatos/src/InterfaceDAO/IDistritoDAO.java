/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import Entidad.Distrito;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author maico
 */
public interface IDistritoDAO extends IGenericoDAO<Distrito, Serializable>{
    public List<Distrito> getAll();
}
