package service;

import model.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    private static Map<Integer,Customer> list;
    static {
        list = new LinkedHashMap<>();
        list.put(1,new Customer(1,"Phạm Lê Đông 1","dong1@gmail.com","Quảng Nam"));
        list.put(2,new Customer(2,"Phạm Lê Đông 2","dong2@gmail.com","Quảng Nam"));
        list.put(3,new Customer(3,"Phạm Lê Đông 3","dong3@gmail.com","Quảng Nam"));
        list.put(4,new Customer(4,"Phạm Lê Đông 4","dong4@gmail.com","Quảng Nam"));
        list.put(5,new Customer(5,"Phạm Lê Đông 5","dong5@gmail.com","Quảng Nam"));
        list.put(6,new Customer(6,"Phạm Lê Đông 6","dong6@gmail.com","Quảng Nam"));
        list.put(7,new Customer(7,"Phạm Lê Đông 7","dong7@gmail.com","Quảng Nam"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(list.values());
    }

    @Override
    public void save(Customer customer) {
        list.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return list.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        list.put(id,customer);
    }

    @Override
    public void remove(int id) {
        list.remove(id);
    }
}
