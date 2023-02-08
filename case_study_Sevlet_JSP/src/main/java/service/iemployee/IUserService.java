package service.iemployee;

import bean.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    boolean insertUser(User user);
    boolean deleteUser(String username);

}
