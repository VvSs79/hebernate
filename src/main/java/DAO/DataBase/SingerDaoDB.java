package DAO.DataBase;

import DAO.Entity.EntitySinger;
import DAO.api.ISingerDao;
import DTO.Singer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class SingerDaoDB implements ISingerDao {

 private final EntityManagerFactory factory;

 public SingerDaoDB(EntityManagerFactory factory) {
  this.factory = factory;
 }
 public synchronized List<Singer> getSingersDB()  {
  List<Singer> ljdto=new ArrayList<>();
  EntityManager em=factory.createEntityManager();
  em.getTransaction().begin();
  try{
  List<EntitySinger> les=em.createQuery("FROM Singer ORDER BY id",EntitySinger.class ).getResultList();
  em.getTransaction().commit();
  em.close();

  for(EntitySinger es:les){
 ljdto.add(new Singer(es.getID(), es.getSingerName()));
  }

  }catch (IllegalArgumentException e){
   throw  new IllegalArgumentException("ошибка в запросе");
  }finally {
   em.close();
  }
  return ljdto;
 }

 public synchronized boolean addSinger(String newNameSinger){
  EntityManager em=factory.createEntityManager();
  em.getTransaction().begin();
  em.persist(new EntitySinger());
  em.getTransaction().commit();
  em.close();
  return true;
 }

 public  synchronized void  updateListSinger(int id, String nameSinger){
  EntityManager em=factory.createEntityManager();
  em.getTransaction().begin();
  EntitySinger singeUpdate=em.find(EntitySinger.class,id);
  singeUpdate.setSingerName(nameSinger);
  em.merge(singeUpdate);
  em.getTransaction().commit();
  em.close();
 }

 public  synchronized boolean  deletetSinger(int id){
  EntityManager em =factory.createEntityManager();
  em.getTransaction().begin();
  EntitySinger singerDelete=em.find(EntitySinger.class,id);
  em.remove(singerDelete);
  em.getTransaction().commit();
  return singerDelete!=null? true:false;

 }

 public synchronized boolean exist(int id){
  EntityManager em=factory.createEntityManager();
  em.getTransaction().begin();
  EntitySinger singers=em.find(EntitySinger.class,id);
  em.getTransaction().commit();
  return  singers!=null? true:false;
 }
}

