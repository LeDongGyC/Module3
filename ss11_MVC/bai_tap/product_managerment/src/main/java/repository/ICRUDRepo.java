package repository;

import java.util.List;

public interface ICRUDRepo<T> {
    List<T> findAll();

    void create(T t);

    void update(T t);

    void remove(int id);

    T findById(int id);

    List<T> findByName(String name);
}
