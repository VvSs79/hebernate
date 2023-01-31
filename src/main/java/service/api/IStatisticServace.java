package service.api;

import DTO.InformationTop;
import DTO.Jenre;
import DTO.ResultTopJenres;
import DTO.Singer;
import dto.*;

import java.util.List;
import java.util.Map;

public interface IStatisticServace {
    public Map<List<Singer>, Long> getTopGinger();
    public  List<ResultTopJenres<Jenre>> getTopJAnre();
    public List<InformationTop> getInformationTop();

}
