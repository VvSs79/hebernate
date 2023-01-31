package DAO.DataBase.ds.fabrics;
import DAO.DataBase.ds.DataSoureC3P0;
import DAO.DataBase.ds.api.IDataSourceWrapper;
import java.beans.PropertyVetoException;
import java.util.Properties;

public class DataSourceSingleton {
    private static Properties properties;

    private DataSourceSingleton() {
    }

    private void setProperties(Properties properties){
        synchronized (DataSourceSingleton.class){

        }
        if(instance!=null){
            throw new IllegalArgumentException("Нельзя менять настройки подключения к БД, уже было создано подключние");
        }
        DataSourceSingleton.properties=properties;
    }

    private volatile static IDataSourceWrapper instance;
        public static IDataSourceWrapper getInstance() throws PropertyVetoException {
            if(instance == null){
                synchronized (DataSourceSingleton.class){
                    if(instance == null){
                        instance = new DataSoureC3P0(properties);
                    }
                }
            }
            return instance;
        }
    }

