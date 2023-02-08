package service.impl.employee;

import bean.User;
import repository.iemployee.IUserRepository;
import repository.impl.employee.UserRepository;
import service.iemployee.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private final IUserRepository userRepository = new UserRepository();

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean insertUser(User user) {
        return userRepository.insertUser(user);
    }

    @Override
    public boolean deleteUser(String username) {
        return userRepository.deleteUser(username);
    }
}
