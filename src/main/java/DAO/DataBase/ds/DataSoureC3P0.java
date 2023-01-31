package DAO.DataBase.ds;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.codegen.bean.Property;
import DAO.DataBase.ds.api.IDataSourceWrapper;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSoureC3P0 implements IDataSourceWrapper {
    private static final String DRIVER_CLASS_PROPERTY_NAME="db.class";
    private static final String URL_CLASS_PROPERTY_NAME="db.url";
    private static final String USER_CLASS_PROPERTY_NAME="db.name";
    private static final String PASSWORD_CLASS_PROPERTY_NAME="db.password";
    private ComboPooledDataSource dataSource;
    public DataSoureC3P0(Properties properties) throws PropertyVetoException {
        this.dataSource=new ComboPooledDataSource();
        this.dataSource.setDriverClass(properties.getProperty(DRIVER_CLASS_PROPERTY_NAME));
        this.dataSource.setJdbcUrl(properties.getProperty(URL_CLASS_PROPERTY_NAME));
        this.dataSource.setUser(properties.getProperty(USER_CLASS_PROPERTY_NAME));
        this.dataSource.setPassword(properties.getProperty(PASSWORD_CLASS_PROPERTY_NAME));
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    @Override
    public void close() throws Exception {
        this.dataSource.close();

    }
}
