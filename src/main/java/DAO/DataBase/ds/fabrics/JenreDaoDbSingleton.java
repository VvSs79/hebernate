package DAO.DataBase.ds.fabrics;

import DAO.DataBase.JenreDAOdb;
import DAO.api.IJenreDao;

import java.beans.PropertyVetoException;

public class JenreDaoDbSingleton {

    private volatile static JenreDAOdb instance;

    private JenreDaoDbSingleton() {
    }
    public static IJenreDao getInstance() throws PropertyVetoException {
        if(instance == null){
            synchronized (JenreDaoDbSingleton.class){
                if(instance == null){
                    instance = new JenreDAOdb(DataSourceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
