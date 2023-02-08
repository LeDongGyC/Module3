package repository.impl.customer;

import bean.CustomerType;
import repository.icustomer.ICustomerTypeRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryRepository implements ICustomerTypeRepository {
    private final String SELECT_CUSTOMER_TYPE = "select * from customer_type";
    private final String INSERT_CUSTOMER_TYPE = "insert into customer_type(customer_type_name) value (?)";
    private final String DELETE_CUSTOMER_TYPE = "delete from customer_type where customer_type_id = ?";

    @Override
    public List<CustomerType> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(customerTypeId, customerTypeName));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }

    @Override
    public boolean insertCustomerType(CustomerType customerType) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_TYPE);
            preparedStatement.setString(1, customerType.getCustomerTypeName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomerType(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_TYPE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
