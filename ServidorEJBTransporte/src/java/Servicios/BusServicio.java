/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.BusDAO;
import Entidad.Bus;
import InterfaceDAO.IBusDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author maicol
 */
@Stateless
public class BusServicio implements BusServicioLocal {

    private IBusDAO busDAO;
    

    public BusServicio() {
        busDAO = new BusDAO();
    }
    
    @Override
    public List<Bus> getAll() {
        List<Bus> buses = busDAO.getAll();
        return buses;
    }

    @Override
    public Bus getById(Serializable id) {
        Bus bus = busDAO.getById(id);
        return bus;
    }

    @Override
    public void crear(Bus bus) {
        busDAO.crear(bus);
    }

    @Override
    public void actualizar(Bus bus) {
        busDAO.actualizar(bus);
    }

    @Override
    public void eliminar(Bus bus) {
        busDAO.eliminar(bus);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
