package repository.impl.service;

import bean.ServiceType;
import repository.iservice.IServiceTypeRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    private final String SELECT_ALL_SERVICE_TYPE = "select * from service_type;";
    private final String INSERT_INTO = "insert into service_type(service_type_name) values(?)";
    private final String DELETE_SERVICE_TYPE = "delete from service_type where service_type_id = ?";

    @Override
    public List<ServiceType> findAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_type_id = resultSet.getInt("service_type_id");
                String service_type_name = resultSet.getString("service_type_name");
                ServiceType serviceType = new ServiceType(service_type_id, service_type_name);
                serviceTypeList.add(serviceType);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypeList;
    }

    @Override
    public boolean insertServiceType(ServiceType serviceType) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, serviceType.getServiceTypeName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteServiceType(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE_TYPE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
