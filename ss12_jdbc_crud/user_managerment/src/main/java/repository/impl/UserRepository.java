package repository.impl;

import bean.User;
import repository.IUserRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final String SELECT_ALL = "select * from users";
    private final String SELECT_USERS = "select id,name,email,country from users where id =?";
    private final String FIND_BY_COUNTRY = "select * from users where country like ?";
    private final String INSERT_INTO = "insert into users(name, email, country) values(?,?,?)";
    private final String UPDATE = "update users set name = ?,email= ?, country =? where id = ?";
    private final String DELETE = "delete from users where id = ?";


    @Override
    public boolean add(User user) {
        try (
                Connection connection = BaseRepository.getConnectDB();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try (
                Connection connection = BaseRepository.getConnectDB();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (
                Connection connection = BaseRepository.getConnectDB();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (
                Connection connection = BaseRepository.getConnectDB();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> output = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_COUNTRY);
            preparedStatement.setString(1, "%" + country + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryFound = resultSet.getString("country");
                User user = new User(name, email, countryFound);
                output.add(user);
            }
//            if (output.size() > 0) {
//                return output;
//            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }
}
