/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDAO;

import Entidad.Rutas;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Maicol Rodrigo
 */
public interface IRutasDAO extends IGenericoDAO<Rutas, Serializable>{
    public List<Rutas> getAll();
}
