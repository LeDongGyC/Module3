package service;

import bean.User;

import java.util.List;

public interface IUserService extends ICRUDService<User> {
    List<User> searchByCountry(String country);
}
