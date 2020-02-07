/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidad.Rutas;
import Generico.IGenericoEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maicol
 */
@Local
public interface RutasServicioLocal extends IGenericoEJB<Rutas, Serializable>{
    List<Rutas> getAll();
}
