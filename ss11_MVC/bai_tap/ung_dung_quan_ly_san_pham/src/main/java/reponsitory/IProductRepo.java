package reponsitory;

import bean.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    Product findByName(String name);

    void update(int id, Product product);

    void remove(int id);
}
