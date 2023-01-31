package service;

import DAO.api.IJenreDao;
import DTO.Jenre;
import service.api.IJenreService;

import java.util.List;

public class JenreService implements IJenreService {
    private final IJenreDao dao;

    public JenreService(IJenreDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Jenre> get() {
        return dao.get();
    }

    @Override
    public boolean  exist(int Idjenre) {
        List <Jenre> jenreDTOS=this.dao.get();
        for (Jenre jenreDTO : jenreDTOS) {
            if(Idjenre==jenreDTO.getIdJenre()){
                return true;
            }
            if(Character.isDigit(Idjenre)){
                return true;
            }
        }
        return false;
    }
}
