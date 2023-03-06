package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void add(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);
}
