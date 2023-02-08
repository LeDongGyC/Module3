package service.impl.employee;

import bean.Employee;
import repository.iemployee.IEmployeeRepository;
import repository.impl.employee.EmployeeRepository;
import service.iemployee.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeRepository.insertEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public Employee selectById(int id) {
        return employeeRepository.selectById(id);
    }

    @Override
    public List<Employee> search(String nameSearch, String emailSearch, String positionId) {
        return employeeRepository.search(nameSearch,emailSearch, positionId);
    }
}
