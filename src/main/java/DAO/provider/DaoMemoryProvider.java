package DAO.provider;

import DAO.api.IJenreDao;
import DAO.api.ISingerDao;
import DAO.api.IVoteDao;
import DAO.memory.fabric.JenreDaoMemorySingleton;
import DAO.memory.fabric.SingerDaoMemorySingleton;
import DAO.memory.fabric.VoteDaoMemorySingleton;
import DAO.provider.api.IDaoProvider;

public class DaoMemoryProvider implements IDaoProvider {
    @Override
    public ISingerDao singerDao() {
        return SingerDaoMemorySingleton.getInstance();
    }

    @Override
    public IJenreDao jenreDao() {
        return JenreDaoMemorySingleton.getInstance();
    }

    @Override
    public IVoteDao voteDao() {
        return VoteDaoMemorySingleton.getInstance();
    }
}
