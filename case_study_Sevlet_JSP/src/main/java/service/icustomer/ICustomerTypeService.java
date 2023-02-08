package service.icustomer;

import bean.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    boolean insertCustomerType(CustomerType customerType);
    boolean deleteCustomerType(int id);
}
