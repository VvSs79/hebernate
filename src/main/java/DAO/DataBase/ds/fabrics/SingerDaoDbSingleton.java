package DAO.DataBase.ds.fabrics;

import DAO.DataBase.SingerDaoDB;
import DAO.api.ISingerDao;


import java.beans.PropertyVetoException;

public class SingerDaoDbSingleton {
    private volatile static SingerDaoDB instance;

    public SingerDaoDbSingleton() {
    }

    public static ISingerDao getInstance() throws PropertyVetoException {
        if(instance == null){
            synchronized (SingerDaoDbSingleton.class){
                if(instance == null){
                    instance=new SingerDaoDB(DataSourceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
