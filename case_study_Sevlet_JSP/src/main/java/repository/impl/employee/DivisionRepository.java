package repository.impl.employee;

import bean.Division;
import repository.iemployee.IDivisionRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private final String SELECT_ALL_DIVISION = "select * from division";
    private final String INSERT_INTO = "insert into division(division_name) values (?) ";

    @Override
    public List<Division> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                Division division = new Division(division_id, division_name);
                divisionList.add(division);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return divisionList;
    }

    @Override
    public boolean insertDivision(Division division) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, division.getDivisionName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
