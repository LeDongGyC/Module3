package service.impl;

import bean.Product;
import repository.IProductRepo;
import repository.impl.ProductRepo;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepo productRepo = new ProductRepo();

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void create(Product product) {
        productRepo.create(product);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }

    @Override
    public void remove(int id) {
        productRepo.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }
}
