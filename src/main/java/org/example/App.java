package org.example;

import org.example.entity.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        EntityManagerFactory factory= Persistence.createEntityManagerFactory( "tutorial" );
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new Event( "Our very first event!", new Date() ) );
        entityManager.persist( new Event( "A follow up event", new Date() ) );
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
