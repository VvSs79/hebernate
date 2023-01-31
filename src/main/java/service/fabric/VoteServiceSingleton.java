package service.fabric;

import DAO.provider.ChoiceProvider;
import service.VoteService;

public class VoteServiceSingleton {
    private volatile static VoteService instance;

    private VoteServiceSingleton() {
    }
    public static VoteService getInstance() {
        if(instance==null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new VoteService(ChoiceProvider.getInstance().voteDao(),
                            SingerServiceSingleton.getInstance(),
                            JenreServiceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
