package service.api;

import DTO.Singer;

import java.util.List;

public interface ISingerService {
     List<Singer> get(int IdSinger);
     boolean exist(int Idsinger);
}
