package repository.iemployee;

import bean.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    boolean insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int id);

    Employee selectById(int id);

    List<Employee> search(String nameSearch, String emailSearch, String positionId);
}
