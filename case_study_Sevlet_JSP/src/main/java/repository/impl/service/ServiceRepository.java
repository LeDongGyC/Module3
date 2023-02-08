package repository.impl.service;

import bean.RentType;
import bean.Service;
import bean.ServiceType;
import repository.iservice.IServiceRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private final String SELECT_ALL_SERVICE = "select sv.*,st.service_type_name,rt.rent_type_name from service sv join service_type st on sv.service_type_id = st.service_type_id join rent_type rt on sv.rent_type_id = rt.rent_type_id";
    private final String INSERT_INTO = "insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                int service_area = resultSet.getInt("service_area");
                double service_cost = resultSet.getDouble("service_cost");
                int service_max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                String rent_type_name = resultSet.getString("rent_type_name");
                RentType rentType = new RentType(rent_type_id, rent_type_name);
                int service_type_id = resultSet.getInt("service_type_id");
                String service_type_name = resultSet.getString("service_type_name");
                ServiceType serviceType = new ServiceType(service_type_id, service_type_name);
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                Service service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rentType, serviceType, standard_room, description_other_convenience, pool_area, number_of_floors);
                serviceList.add(service);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean insertService(Service service) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCost());
            preparedStatement.setInt(4, service.getServiceMaxPeople());
            preparedStatement.setInt(5, service.getRentType().getRentTypeId());
            preparedStatement.setInt(6, service.getServiceType().getServiceTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
