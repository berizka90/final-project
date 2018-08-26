package service;

import model.NotUniqueFieldException;
import model.entity.User;


import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    Integer create(User contact) throws SQLException;
    List<User> findAll() throws SQLException;
    void checkLogin(String login) throws NotUniqueFieldException;
    void checkPassword(String mobile) throws NotUniqueFieldException;

}
