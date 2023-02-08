package repository.impl.employee;

import bean.*;
import repository.iemployee.IEmployeeRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String SELECT_ALL_EMPLOYEE = "select e.*,p.position_name,ed.education_degree_name,dv.division_name,u.username from employee e\n" +
            "join position p on e.position_id = p.position_id\n" +
            "join education_degree ed on e.education_degree_id = ed.education_degree_id\n" +
            "join division dv on e.division_id = dv.division_id\n" +
            "join user u on e.username = u.username;";
    private final String INSERT_INTO = "insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)\n" +
            "values (?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ? where employee_id = ?";
    private final String DELETE = "delete from employee where employee_id = ?";
    private final String SELECT_EMPLOYEE_BY_ID = "select e.*,p.position_name,ed.education_degree_name,dv.division_name,u.username from employee e\n" +
            "join position p on e.position_id = p.position_id\n" +
            "join education_degree ed on e.education_degree_id = ed.education_degree_id\n" +
            "join division dv on e.division_id = dv.division_id\n" +
            "join user u on e.username = u.username\n" +
            "where e.employee_id = ?;";
    private final String SEARCH = "select e.*,p.position_name,ed.education_degree_name,dv.division_name,u.username from employee e join position p on e.position_id = p.position_id join education_degree ed on e.education_degree_id = ed.education_degree_id join division dv on e.division_id = dv.division_id join user u on e.username = u.username where e.employee_name like ? and e.employee_email like ? and e.position_id like ?";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                Position position = new Position(position_id, position_name);
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(education_degree_id, education_degree_name);
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                Division division = new Division(division_id, division_name);
                String username = resultSet.getString("username");
                User user = new User(username);
                Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position, educationDegree, division, user);
                employeeList.add(employee);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPosition().getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegree().getEducationDegree());
            preparedStatement.setInt(10, employee.getDivision().getDivisionId());
            preparedStatement.setString(11, employee.getUser().getUserName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPosition().getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegree().getEducationDegree());
            preparedStatement.setInt(10, employee.getDivision().getDivisionId());
            preparedStatement.setString(11, employee.getUser().getUserName());
            preparedStatement.setInt(12, employee.getEmployeeId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee selectById(int id) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                Position position = new Position(position_id, position_name);
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(education_degree_id, education_degree_name);
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                Division division = new Division(division_id, division_name);
                String username = resultSet.getString("username");
                User user = new User(username);
                employee = new Employee(id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position, educationDegree, division, user);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> search(String nameSearch, String emailSearch, String positionId) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + nameSearch + "%");
            preparedStatement.setString(2, "%" + emailSearch + "%");
            preparedStatement.setString(3, "%" + positionId + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                Position position = new Position(position_id, position_name);
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(education_degree_id, education_degree_name);
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                Division division = new Division(division_id, division_name);
                String username = resultSet.getString("username");
                User user = new User(username);
                Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position, educationDegree, division, user);
                employeeList.add(employee);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
