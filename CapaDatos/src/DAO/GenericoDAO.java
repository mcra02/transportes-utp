/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import InterfaceDAO.IGenericoDAO;
import Utils.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author maico
 */
public class GenericoDAO <Entity, K extends Serializable> implements IGenericoDAO<Entity, K>{

    public Class<Entity> domainClass = getDomainClass();
    
    Session session = null;
    Transaction tx = null;
    public String mess = "";
    int maxResults = 100;
    
    private SessionFactory factory;
    
    public GenericoDAO(){
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
    
    
    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }
    
    private Session getHibernateTemplate() {
        HibernateUtil utilitario = new HibernateUtil();
        factory = utilitario.getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        return session;
    }
    
    @Override
    public Entity getById(K id) {
        Entity returnValue = (Entity) getHibernateTemplate().get(domainClass, id);
        session.getTransaction().commit();
        return returnValue;
    }

    @Override
    public void crear(Entity entity) {
        try {
            getHibernateTemplate().save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    @Override
    public void actualizar(Entity entity) {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    @Override
    public void eliminar(Entity entity) {
        getHibernateTemplate().delete(entity);
        session.getTransaction().commit();
    }
    
}
