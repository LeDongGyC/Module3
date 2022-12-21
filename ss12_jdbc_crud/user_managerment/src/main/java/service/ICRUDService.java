package service;

import java.util.List;

public interface ICRUDService<T> {
    boolean add(T t);

    boolean update(T t);

    boolean delete(int id);

    T findById(int id);

    List<T> findAll();


}
