/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Maicol Rodrigo
 */
public class HibernateUtil {

    private SessionFactory sessionFactory;
    
    public HibernateUtil()
    {
        try 
        {   if (sessionFactory == null) 
            {   Configuration configuration = new Configuration().configure(); 
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()); 
                sessionFactory = configuration.buildSessionFactory(builder.build()); 
            }
        } 
        catch (Throwable ex) 
        {   System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public  SessionFactory getSessionFactory() 
    {   if (sessionFactory == null) 
        {
            Configuration configuration = new Configuration().configure(); 
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()); 
            sessionFactory = configuration.buildSessionFactory(builder.build()); 
        }
        return sessionFactory;
    }
}
