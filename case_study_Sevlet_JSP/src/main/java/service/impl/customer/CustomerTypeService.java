package service.impl.customer;

import bean.CustomerType;
import repository.impl.customer.CustomerTypeRepositoryRepository;
import repository.icustomer.ICustomerTypeRepository;
import service.icustomer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private final ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryRepository();

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public boolean insertCustomerType(CustomerType customerType) {
        return customerTypeRepository.insertCustomerType(customerType);
    }

    @Override
    public boolean deleteCustomerType(int id) {
        return customerTypeRepository.deleteCustomerType(id);
    }
}
