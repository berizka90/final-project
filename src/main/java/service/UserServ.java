package service;

import exception.UnknownUserException;
import model.entity.User;
import model.entity.UserRole;


import java.util.List;

public interface UserServ {
    /** Find all Users in DB
     * @return list of all users
     * @trows UnknownUserException if unable to retrieve information for certain reasons
     */
    List<User> findAllUsers() throws UnknownUserException;
    /**
     * Finds all users by User Role
     * @param userRole - User role
     * @return List of all users with @param userRole
     * @throws UnknownUserException if unable to retrieve information for certain reasons
     */
    List<User> findUsersByRole(UserRole userRole) throws UnknownUserException;

    /**
     * Finds user by User name and password
     * @param name - User name
     * @param password - user password
     * @return user found by username and password
     * @throws UnknownUserException if unable to retrieve information for certain reasons
     */
    User findUser(String name, String password) throws UnknownUserException;

    /**
     * Adds a new user in DB
     * @param user - user to add
     * @return true if operation success and false if fails
     */
    boolean addUser(User user);

    /**
     * Updates existent user data in DB
     * @param user -  user to update
     * @return true if operation success and false if fails
     */
    boolean updateUser(User user);

    /**
     * Deletes user from DB
     * @param user - user to delete
     * @return true if operation success and false if fails
     */
    boolean deleteUser(User user);
}

