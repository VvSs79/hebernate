package service.fabric;

import service.StatisticService;
import service.api.IStatisticServace;

public class StatisticServiceSingleton {

        private volatile static StatisticService instance;

        private IStatisticServace getInstance() {
            if(instance==null){
                synchronized (StatisticServiceSingleton.class){
                    if(instance==null){
                        instance=new StatisticService(
                                SingerServiceSingleton.getInstance(),
                                JenreServiceSingleton.getInstance(),
                                VoteServiceSingleton.getInstance());

                    }
                }
            }
            return instance;
        }
    }

