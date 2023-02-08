package service.iemployee;

import bean.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    boolean insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int id);

    Employee selectById(int id);

    List<Employee> search(String nameSearch, String emailSearch, String positionId);
}
