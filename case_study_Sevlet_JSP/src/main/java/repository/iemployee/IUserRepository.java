package repository.iemployee;

import bean.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();

    boolean insertUser(User user);
    boolean deleteUser(String username);
}
