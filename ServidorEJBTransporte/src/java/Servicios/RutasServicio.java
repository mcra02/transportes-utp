/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.RutasDAO;
import Entidad.Rutas;
import InterfaceDAO.IRutasDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author maicol
 */
@Stateless
public class RutasServicio implements RutasServicioLocal {

    private IRutasDAO rutasDAO;
    

    public RutasServicio() {
        rutasDAO = new RutasDAO();
    }
    
    @Override
    public List<Rutas> getAll() {
        List<Rutas> rutas = rutasDAO.getAll();
        return rutas;
    }

    @Override
    public Rutas getById(Serializable id) {
        Rutas ruta = rutasDAO.getById(id);
        return ruta;
    }

    @Override
    public void crear(Rutas rut) {
        rutasDAO.crear(rut);
    }

    @Override
    public void actualizar(Rutas rut) {
        rutasDAO.actualizar(rut);
    }

    @Override
    public void eliminar(Rutas rut) {
        rutasDAO.eliminar(rut);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
