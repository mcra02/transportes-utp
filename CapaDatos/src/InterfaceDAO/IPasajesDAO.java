/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import Entidad.Pasajes;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author maicol
 */
public interface IPasajesDAO extends IGenericoDAO<Pasajes, Serializable>{
    public List<Pasajes> getAll();
}
