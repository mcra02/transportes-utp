/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.DepartamentoDAO;
import Entidad.Departamento;
import InterfaceDAO.IDepartamentoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author maicol
 */
@Stateless
public class DepartamentoServicio implements DepartamentoServicioLocal {

    /*
    private IDepartamentoDAO departamentoDAO;


    public DepartamentoServicio() {
        departamentoDAO = new DepartamentoDAO();
    }
*/
    @Override
    public List<Departamento> getAll() {
        
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> departamentos = departamentoDAO.getAll();
        return departamentos;

    }

    
    @Override
    public Departamento getById(Serializable id) {
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Departamento departamento = departamentoDAO.getById(id);
        return departamento;
    }

    @Override
    public void crear(Departamento dep) {
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        departamentoDAO.crear(dep);
    }

    @Override
    public void actualizar(Departamento dep) {
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        departamentoDAO.actualizar(dep);
    }

    @Override
    public void eliminar(Departamento dep) {
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        departamentoDAO.eliminar(dep);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
