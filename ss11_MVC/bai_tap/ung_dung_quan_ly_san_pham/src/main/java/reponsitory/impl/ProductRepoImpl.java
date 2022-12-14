package reponsitory.impl;

import bean.Product;
import reponsitory.IProductRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepoImpl implements IProductRepo {
    private static final Map<Integer, Product> list;

    static {
        list = new HashMap<>();
        list.put(1, new Product(1, "Iphone", 30000, 100, "USA"));
        list.put(2, new Product(2, "SamSung", 15000, 75, "KOREAN"));
        list.put(3, new Product(3, "ViVo", 5000, 30, "CHINA"));
        list.put(4, new Product(4, "BPhone", 20000, 150, "VIETNAM"));
        list.put(5, new Product(5, "Xiaomi", 8000, 50, "CHINA"));
        list.put(6, new Product(6, "RedMi", 5000, 40, "CHINA"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(list.values());
    }

    @Override
    public void save(Product product) {
        list.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return list.get(id);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
        list.put(id, product);
    }

    @Override
    public void remove(int id) {
        list.remove(id);
    }
}
