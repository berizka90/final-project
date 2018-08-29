package service.impl;

import exception.UnknownUserException;
import model.entity.User;
import model.entity.UserRole;
import service.UserServ;

import java.util.List;

public class UserService implements UserServ {
    @Override
    public List<User> findAllUsers() throws UnknownUserException {
        return null;
    }

    @Override
    public List<User> findUsersByRole(UserRole userRole) throws UnknownUserException {
        return null;
    }

    @Override
    public User findUser(String name, String password) throws UnknownUserException {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
