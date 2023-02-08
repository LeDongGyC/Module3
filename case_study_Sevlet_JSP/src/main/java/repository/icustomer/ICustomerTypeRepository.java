package repository.icustomer;

import bean.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> findAll();
    boolean insertCustomerType(CustomerType customerType);
    boolean deleteCustomerType(int id);
}
