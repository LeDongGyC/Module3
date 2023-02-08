package repository.impl.customer;

import bean.Customer;
import bean.CustomerType;
import repository.icustomer.ICustomerRepository;
import utils.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String SELECT_ALL_CUSTOMER = "select c.*,ct.customer_type_name from customer c join customer_type ct on c.customer_type_id = ct.customer_type_id";
    private final String INSERT_CUSTOMER = "insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values( ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?,customer_name = ?,customer_birthday = ?,customer_gender = ?,customer_id_card = ?,customer_phone = ?,customer_email = ?,customer_address = ? where customer_id = ?";
    private final String SELECT_CUSTOMER_BY_ID = "select c.*,ct.customer_type_name from customer c join customer_type ct on c.customer_type_id = ct.customer_type_id where c.customer_id = ?";
    private final String DELETE_CUSTOMER = "delete from customer where customer_id = ?";
    private final String DELETE_CUSTOMER_BY_ID = "call delete_customer_by_id(?)";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customer_type_id, customer_type_name);
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                Customer customer = new Customer(customer_id, customerType, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
                customerList.add(customer);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
//    public boolean deleteCustomer(int id) {
//        Connection connection = BaseRepository.getConnectDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
//            preparedStatement.setInt(1, id);
//            return preparedStatement.executeUpdate() > 0;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
//    }
    public boolean deleteCustomer(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_CUSTOMER_BY_ID);
            callableStatement.setInt(1, id);
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer selectById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customer_type_id, customer_type_name);
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer = new Customer(id, customerType, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
