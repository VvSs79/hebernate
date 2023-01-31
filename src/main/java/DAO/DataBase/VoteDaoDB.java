package DAO.DataBase;

import DAO.DataBase.ds.api.IDataSourceWrapper;
import DAO.DataBase.ds.fabrics.DataSourceSingleton;
import DAO.api.IVoteDao;
import DTO.SaveInformationDTO;
import DTO.VoteDTO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteDaoDB implements IVoteDao {
    private final IDataSourceWrapper dataSource;

    public VoteDaoDB(IDataSourceWrapper dataSource) throws PropertyVetoException {
        this.dataSource = DataSourceSingleton.getInstance();
    }



    @Override
    public void save(VoteDTO vote) {
        List<VoteDTO> lvdto=new ArrayList<>();
        try(Connection connection= dataSource.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT id, name FROM app.Singer"+"ORDER BY id;")){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String name= resultSet.getString("name");
                lvdto.add(new VoteDTO(id,name));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return   lvdto;
    }


    }

    @Override
    public List<SaveInformationDTO> get() {
        return null;
    }

}
