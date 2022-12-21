package repository;

import java.util.List;

public interface ICRUDRepository<T> {
    boolean add(T t);

    boolean update(T t);

    boolean delete(int id);

    T findById(int id);

    List<T> findAll();

}
