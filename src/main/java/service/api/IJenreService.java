package service.api;

import DTO.Jenre;

import java.util.List;

public interface IJenreService {
    List<Jenre>  get();
    boolean exist(int Idjenre);
}

