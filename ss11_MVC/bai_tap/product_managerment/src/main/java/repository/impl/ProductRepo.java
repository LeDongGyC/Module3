package repository.impl;

import bean.Product;
import repository.IProductRepo;

import java.util.*;

public class ProductRepo implements IProductRepo {
    private static final Map<Integer, Product> map;

    static {
        map = new HashMap<>();
        map.put(1, new Product(1, "IPhone 4", 4000, 20, "USA"));
        map.put(2, new Product(2, "IPhone 5", 5000, 25, "USA"));
        map.put(3, new Product(3, "IPhone 6", 6000, 30, "USA"));
        map.put(4, new Product(4, "IPhone 7", 7000, 40, "USA"));
        map.put(5, new Product(5, "IPhone 8", 8000, 50, "USA"));
        map.put(6, new Product(6, "IPhone X", 10000, 60, "USA"));
    }

    @Override

    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void create(Product product) {
        map.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        map.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new LinkedList<>();
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (map.get(key).getName().equals(name)) {
                result.add(map.get(key));
            }
        }
        return result;
    }
}
