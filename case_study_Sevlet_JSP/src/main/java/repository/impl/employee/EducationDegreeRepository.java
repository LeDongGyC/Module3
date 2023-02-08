package repository.impl.employee;

import bean.EducationDegree;
import repository.iemployee.IEducationDegreeRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private final String SELECT_ALL_EDUCATION_DEGREE = "select * from education_degree";
    private final String INSERT_INTO = "insert into education_degree(education_degree_name) values (?)";

    @Override
    public List<EducationDegree> findAll() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(education_degree_id, education_degree_name);
                educationDegreeList.add(educationDegree);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }

    @Override
    public boolean insertEducationDegree(EducationDegree educationDegree) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, educationDegree.getEducationDegreeName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
