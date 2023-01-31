package DAO.provider;

import DAO.api.IJenreDao;
import DAO.api.ISingerDao;
import DAO.api.IVoteDao;
import DAO.provider.api.IDaoProvider;

public class ChoiceProvider implements IDaoProvider {
private final boolean DB=true;
private final IDaoProvider iDaoProvider;
private static volatile ChoiceProvider instance;

public ChoiceProvider(){
    if(DB) {
        iDaoProvider = new DaoDbProvider();
    } else {
       throw new IllegalArgumentException("not choice provider");
    }
}


    @Override
    public ISingerDao singerDao() {
        return iDaoProvider.singerDao();
    }

    @Override
    public IJenreDao jenreDao() {
        return iDaoProvider.jenreDao();
    }

    @Override
    public IVoteDao voteDao() {
        return iDaoProvider.voteDao();
    }
    public static IDaoProvider getInstance(){
    if(instance==null){
        synchronized (ChoiceProvider.class){
            if(instance==null){
                instance=new ChoiceProvider();
            }
        }
    }
    return instance;
    }
}

