package repository.impl.employee;

import bean.Position;
import repository.iemployee.IPositionRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private final String SELECT_ALL_POSITION = "select * from position";
    private final String INSERT_INTO = "insert into `position`(position_name) values(?)";

    @Override
    public List<Position> findAll() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                Position position = new Position(position_id, position_name);
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }

    @Override
    public boolean insertPosition(Position position) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, position.getPositionName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
