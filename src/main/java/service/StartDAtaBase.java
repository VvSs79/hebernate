package service;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class StartDAtaBase {
    private final String URL = "jdbc:postgresql://localhost:5432/voting";
    private final String login = "group_5";
    private final String password = "g5r5o5u5p";
    private final int  MaxID=10;
    private final int  MaxTotalRespondent=20;
    private final int timeWaiting=-1;

    ComboPooledDataSource cpds = new ComboPooledDataSource();

    public void StartDB() {
        try{
            cpds.setDriverClass( "org.postgresql.Driver" );
        }catch (PropertyVetoException e){
            throw new RuntimeException(e);
        }
    }
    public Connection load () throws SQLException {
        cpds.setJdbcUrl(URL);
        cpds.setUser(login);
        cpds.setPassword(password);
        cpds.setCheckoutTimeout(timeWaiting);
        return cpds.getConnection();
    }

    public boolean selectSQL(){
        boolean selrcrSQL=true;
        return selrcrSQL? selrcrSQL:false;
    }
}
