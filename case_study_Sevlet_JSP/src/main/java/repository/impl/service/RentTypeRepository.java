package repository.impl.service;

import bean.Contract;
import bean.RentType;
import repository.iservice.IRentTypeRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    private final String SELECT_ALL_RENT_TYPE = "select * from rent_type";
    private final String INSERT_INTO = "insert into rent_type(rent_type_name,rent_type_cost) values(?,?)";
    private final String DELETE_RENT_TYPE = "delete from rent_type where rent_type_id = ?";
    @Override
    public List<RentType> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int rent_type_id = resultSet.getInt("rent_type_id");
                String rent_type_name = resultSet.getString("rent_type_name");
                Double rent_type_cost = resultSet.getDouble("rent_type_cost");
                RentType rentType = new RentType(rent_type_id,rent_type_name,rent_type_cost);
                rentTypeList.add(rentType);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }

    @Override
    public boolean insertRentType(RentType rentType) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,rentType.getRentTypeName());
            preparedStatement.setDouble(2,rentType.getRentTypeCost());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteRentType(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RENT_TYPE);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
