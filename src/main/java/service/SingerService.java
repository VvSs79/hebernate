package service;

import DAO.api.ISingerDao;
import DTO.Singer;
import service.api.ISingerService;

import java.util.List;

public class SingerService implements ISingerService {
    private final ISingerDao dao;

    public SingerService(ISingerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Singer> get(int IdSinger) {
        List <Singer> singerDTOS=this.dao.get();
        for (Singer singerDTO : singerDTOS) {
            if(IdSinger==singerDTO.getIdSinger()){
                return singerDTOS;
            }
        }
        return null;
    }

    @Override
    public boolean exist(int Idsinger) {
       List <Singer> singerDTOS=this.dao.get();
       for (Singer singerDTO : singerDTOS) {
           if(Idsinger==singerDTO.getIdSinger()){
               return true;
           }
           if(Character.isDigit(Idsinger)){
               return true;
           }
       }
            return false;
    }
}

