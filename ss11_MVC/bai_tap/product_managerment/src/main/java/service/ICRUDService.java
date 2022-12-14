package service;

import java.util.List;

public interface ICRUDService<T> {
    List<T> findAll();

    void create(T t);

    void update(T t);

    void remove(int id);

    T findById(int id);

    List<T> findByName(String name);
}
