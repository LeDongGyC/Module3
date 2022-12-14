package service.impl;

import bean.Product;
import reponsitory.IProductRepo;
import reponsitory.impl.ProductRepoImpl;
import service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private final IProductRepo iProductRepo = new ProductRepoImpl();

    @Override
    public List<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return iProductRepo.findByName(name);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepo.update(id, product);
    }

    @Override
    public void remove(int id) {
        iProductRepo.remove(id);
    }
}
