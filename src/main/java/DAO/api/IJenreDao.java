package DAO.api;

import DTO.Jenre;

import java.util.List;

public interface IJenreDao {
    List<Jenre> get();
    boolean exist (String jenreName);
}
