package service.impl.customer;

import bean.Customer;
import repository.impl.customer.CustomerRepository;
import repository.icustomer.ICustomerRepository;
import service.icustomer.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        return customerRepository.insertCustomer(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public Customer selectById(int id) {
        return customerRepository.selectById(id);
    }
}
