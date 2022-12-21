package repository;

import bean.User;

import java.util.List;

public interface IUserRepository extends ICRUDRepository<User>{
    List<User> searchByCountry(String country);
}
