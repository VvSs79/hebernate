package DAO.provider;

import DAO.DataBase.ds.fabrics.JenreDaoDbSingleton;
import DAO.api.IJenreDao;
import DAO.api.ISingerDao;
import DAO.api.IVoteDao;
import DAO.provider.api.IDaoProvider;

import java.beans.PropertyVetoException;

public class DaoDbProvider implements IDaoProvider {
    @Override
    public ISingerDao singerDao() {
        return null;
    }

    @Override
    public IJenreDao jenreDao() {
        try {
            return JenreDaoDbSingleton.getInstance();
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IVoteDao voteDao() {
        return null;
    }
}
