/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.PasajesDAO;
import Entidad.Pasajes;
import InterfaceDAO.IPasajesDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Maicol Rodrigo
 */
@Stateless
public class PasajesServicio implements PasajesServicioLocal {

    private IPasajesDAO pasajesDAO;

    public PasajesServicio() {
        pasajesDAO = new PasajesDAO();
    }
    
    @Override
    public List<Pasajes> getAll() {
        List<Pasajes> pasajes = pasajesDAO.getAll();
        return pasajes;
    }

    @Override
    public Pasajes getById(Serializable id) {
        Pasajes pasajes = pasajesDAO.getById(id);
        return pasajes;
    }

    @Override
    public void crear(Pasajes pas) {
        pasajesDAO.crear(pas);
    }

    @Override
    public void actualizar(Pasajes pas) {
        pasajesDAO.actualizar(pas);
    }

    @Override
    public void eliminar(Pasajes pas) {
        pasajesDAO.eliminar(pas);
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
