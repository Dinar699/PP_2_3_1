package web.servise;

import web.model.User;

import java.util.List;

public interface UserServise {
    List<User> getAllUser();

    void add(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);
}
