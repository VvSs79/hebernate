package DAO.api;

import DTO.Singer;

import java.util.List;

public interface ISingerDao {
   List<Singer> getSingersDB();
    boolean addSinger(String newNameSinger);
    void  updateListSinger(int id, String nameSinger);
    boolean  deletetSinger(int id);
    boolean exist(int id);
}
