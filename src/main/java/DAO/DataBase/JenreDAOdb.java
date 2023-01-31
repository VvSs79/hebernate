package DAO.DataBase;

import DAO.DataBase.ds.api.IDataSourceWrapper;
import DAO.Entity.EntityJenre;
import DAO.api.IJenreDao;
import DTO.Jenre;
import DTO.Singer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.RejultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JenreDAOdb implements IJenreDao {


    private final EntityManagerFactory factory;

    public JenreDAOdb(EntityManagerFactory factory) {
        this.factory = factory;
    }
    public synchronized List<Jenre> getsJenreDB()  {
        List<Jenre> list=new ArrayList<>();
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        try{
            List<EntityJenre> lej=em.createQuery("FROM Jenre ORDER BY id",EntityJenre.class ).getResultList();
            em.getTransaction().commit();
            em.close();

            for(EntityJenre ej:lej){
                list.add(new Jenre(ej.getID(), ej.getJenreName()));
            }

        }catch (IllegalArgumentException e){
            throw  new IllegalArgumentException("ошибка в запросе");
        }finally {
            em.close();
        }
        return list;
    }

    public synchronized boolean addJenre(){
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(new EntityJenre());
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public  synchronized void  updateListJenre(int id, String nameJanre){
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        EntityJenre jenreUpdate=em.find(EntityJenre.class,id);
        jenreUpdate.setJenreName(nameJanre);
        em.merge(jenreUpdate);
        em.getTransaction().commit();
        em.close();
    }

    public  synchronized boolean  deletetSinger(int id){
        EntityManager em =factory.createEntityManager();
        em.getTransaction().begin();
        EntityJenre jenreDelete=em.find(EntityJenre.class,id);
        em.remove(jenreDelete);
        em.getTransaction().commit();
        return jenreDelete!=null? true:false;

    }

    public synchronized boolean exist(int id){
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        EntityJenre jenres=em.find(EntityJenre.class,id);
        em.getTransaction().commit();
        return  jenres!=null? true:false;
    }
}




