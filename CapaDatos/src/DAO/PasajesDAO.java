/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Pasajes;
import InterfaceDAO.IPasajesDAO;
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
 * @author Maicol Rodrigo
 */
public class PasajesDAO extends GenericoDAO<Pasajes, Serializable> implements IPasajesDAO{

    Session session = null;
    Transaction tx = null;
    public String mess = "";
    int maxResults = 100;
    
    private SessionFactory factory;
    
    public PasajesDAO(){
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
    public List<Pasajes> getAll() {
        List<Pasajes> pasajes = null;

        if(!session.isOpen()){
            this.openSession();
        }
        try {
            Query q = null;
            q = session.createQuery("from Pasajes dep");
            pasajes = (List<Pasajes>) q.list();
        } catch (HibernateException e) {
            mess = e.getMessage();
            tx.rollback();
            e.printStackTrace();
        }
        return pasajes;
    }
    
}
