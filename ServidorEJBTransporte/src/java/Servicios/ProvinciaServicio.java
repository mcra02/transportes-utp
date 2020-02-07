/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.ProvinciaDAO;
import Entidad.Provincia;
import InterfaceDAO.IProvinciaDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author maicol
 */
@Stateless
public class ProvinciaServicio implements ProvinciaServicioLocal {

    private IProvinciaDAO provinciaDAO;
    public ProvinciaServicio(){
        provinciaDAO = new ProvinciaDAO();
    }
    
    @Override
    public List<Provincia> getAll() {
        List<Provincia> provincias = provinciaDAO.getAll();
        return provincias;
    }

    @Override
    public Provincia getById(Serializable id) {
        Provincia provincia = provinciaDAO.getById(id);
        return provincia;
    }

    @Override
    public void crear(Provincia pro) {
        provinciaDAO.crear(pro);
    }

    @Override
    public void actualizar(Provincia pro) {
        provinciaDAO.actualizar(pro);
    }

    @Override
    public void eliminar(Provincia pro) {
        provinciaDAO.eliminar(pro);
    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
