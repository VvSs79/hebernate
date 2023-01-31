package service.fabric;

import DAO.provider.ChoiceProvider;
import service.SingerService;
import service.api.ISingerService;


public class SingerServiceSingleton {
    private volatile static SingerService instance;

    public SingerServiceSingleton() {
    }
    public  static ISingerService getInstance(){
        if(instance==null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new SingerService(ChoiceProvider.getInstance().singerDao());
                }
            }
        }
        return instance;
    }
}
