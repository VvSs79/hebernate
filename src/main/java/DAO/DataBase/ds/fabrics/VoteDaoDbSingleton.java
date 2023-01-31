package DAO.DataBase.ds.fabrics;

import DAO.DataBase.VoteDaoDB;
import DAO.api.IVoteDao;
import service.fabric.VoteServiceSingleton;

import java.beans.PropertyVetoException;

public class VoteDaoDbSingleton {
    private volatile  static VoteDaoDB instance;

    private VoteDaoDbSingleton() {
    }
    public static IVoteDao getInstance() throws PropertyVetoException {
        if(instance==null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new VoteDaoDB(DataSourceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
