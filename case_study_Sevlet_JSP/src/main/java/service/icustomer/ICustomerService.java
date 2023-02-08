package service.icustomer;

import bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    boolean insertCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(int id);

    Customer selectById(int id);

}
