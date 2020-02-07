/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Provincia;
import InterfaceDAO.IProvinciaDAO;
import Utils.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author maicol
 */
public class ProvinciaDAO extends GenericoDAO<Provincia, Serializable> implements IProvinciaDAO{

    Session session = null;
    Transaction tx = null;
    public String mess = "";
    int maxResults = 100;
    
    private SessionFactory factory;
    
    public ProvinciaDAO(){
        try{
            HibernateUtil utilitario = new HibernateUtil();
            factory = utilitario.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    public void openSession(){
        HibernateUtil utilitario = new HibernateUtil();
        factory = utilitario.getSessionFactory();
        session = factory.openSession();
        tx = session.beginTransaction();
    }
    
    @Override
    public List<Provincia> getAll() {
        List<Provincia> provincias = null;

        if(!session.isOpen()){
            this.openSession();
        }
        try {
            Query q = null;
            q = session.createQuery("from Provincia dep");
            provincias = (List<Provincia>) q.list();
        } catch (HibernateException e) {
            mess = e.getMessage();
            tx.rollback();
            e.printStackTrace();
        }
        return provincias;
    }
    
}
