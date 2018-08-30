package service.impl;

import exception.DataBaseConnectionException;
import exception.DataNotFoundException;
import exception.UnknownUserException;
import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;
import model.entity.UserRole;
import org.apache.log4j.Logger;
import service.UserServ;

import javax.naming.NamingException;
import java.util.List;

public class UserService implements UserServ {
    private static final Logger log = Logger.getLogger(UserService.class);
    private static DaoFactory daoFactory;
    private static UserDao userDao;

    static {

        try {
           daoFactory = DaoFactory.getDaoFactory();
            userDao=daoFactory.getUserDao();
        } catch (NamingException  e) {
           log.error(e);
        }
    }
    @Override
    public User findUser(String name, String password) throws UnknownUserException {
        User user;
        try {
            daoFactory.open();
            user=userDao.findUserByName(name);
            daoFactory.close();
            if (!user.getPassword().equals(password)){
                throw new UnknownUserException();
            }
            return user;
        }
        catch ( DataBaseConnectionException | DataNotFoundException e)
        {
            log.error(e);
            throw new UnknownUserException();
        }
    }



    @Override
    public List<User> findAllUsers() throws UnknownUserException {
        List<User> users;
        try {
            daoFactory.open();
            users=userDao.findAllUsersInDB();
            daoFactory.close();
            return users;
        }
        catch (DataBaseConnectionException | DataNotFoundException e){
            log.error(e);
            throw new  UnknownUserException();
        }

    }

    @Override
    public List<User> findUsersByRole(UserRole userRole) throws UnknownUserException {
        List<User> users;
        try {
            daoFactory.open();
            users=userDao.findUserByRole(userRole);
            daoFactory.close();
            return users;
        } catch (DataNotFoundException | DataBaseConnectionException e) {
            log.error(e);
            throw new UnknownUserException();
        }
    }
    /** User validation method to check user before storing in DB */
    private boolean validateUserData(User user){
        return  !(user.getLogin()==null || user.getPassword()==null);
    }

    @Override
    public Integer calculateUsersNumber() {
        int count=0;
        try {
            daoFactory.beginTransaction();
            count=userDao.calculateUsersNumber();
            daoFactory.commitTransaction();
        } catch (DataNotFoundException | DataBaseConnectionException e) {
            log.error(e);
        }
        return count;

    }
    @Override
    public synchronized boolean addUser(User user) {
        boolean result;
        try {
            daoFactory.open();
           result = validateUserData(user) && userDao.addUserToDB(user);
            daoFactory.close();
        } catch (DataBaseConnectionException e) {
           log.error(e);
           return false;
        }
        return result;
           }

    @Override
    public synchronized boolean updateUser(User user) {
        boolean result;
        try {
            daoFactory.open();
            result=userDao.updateUserInDB(user);
            daoFactory.close();
        } catch (DataBaseConnectionException e) {
            log.error(e);
            return false;
        }
        return result;
    }

    @Override
    public synchronized boolean deleteUser(User user) {
        boolean result;
        try {
            daoFactory.open();
            result=userDao.deleteUserFromDB(user);
            daoFactory.close();
        } catch (DataBaseConnectionException e) {
            log.error(e);
            return false;
        }
        return result;
    }
}
