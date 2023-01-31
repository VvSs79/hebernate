package DAO.provider.api;

import DAO.api.IJenreDao;
import DAO.api.ISingerDao;
import DAO.api.IVoteDao;

public interface IDaoProvider {
    ISingerDao singerDao();
    IJenreDao jenreDao();
    IVoteDao voteDao();
}
