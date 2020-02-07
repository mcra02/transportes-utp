/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.DistritoDAO;
import Entidad.Distrito;
import InterfaceDAO.IDistritoDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Maicol Rodrigo
 */
@Stateless
public class DistritoServicio implements DistritoServicioLocal {

    private IDistritoDAO distritoDAO;

    public DistritoServicio() {
        distritoDAO = new DistritoDAO();
    }

    @Override
    public List<Distrito> getAll() {
        List<Distrito> distritos = distritoDAO.getAll();
        return distritos;
    }

    @Override
    public Distrito getById(Serializable id) {
        Distrito distrito = distritoDAO.getById(id);
        return distrito;
    }

    @Override
    public void crear(Distrito dis) {
        distritoDAO.crear(dis);
    }

    @Override
    public void actualizar(Distrito dis) {
        distritoDAO.actualizar(dis);
    }

    @Override
    public void eliminar(Distrito dis) {
        distritoDAO.eliminar(dis);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
