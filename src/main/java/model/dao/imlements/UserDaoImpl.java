package model.dao.imlements;

import exception.DataNotFoundException;
import model.dao.GenericAbstractDao;
import model.dao.UserDao;
import model.entity.User;
import model.entity.UserRole;

import java.sql.Connection;
import java.util.List;

public  class UserDaoImpl extends  GenericAbstractDao <User> implements UserDao {
    private Connection connection;
    private static String SQL_select_all="SELECT * FROM users; ";
    private static String SQL_select_byId="SELECT * FROM users WHERE idUser=?;";
    private static String SQL_select_byName="SELECT * FROM users WHERE name=?;";
    private static String SQL_select_byRole="SELECT * FROM users WHERE role=?;";
    private static String SQL_addNew="INSERT INTO mydb.users (name, " +
            "login, password, role) VALUES (?,?,?,?);";
    private static String SQL_update_byId="UPDATE mydb.users SET name=?," +
            " login=?, password=? WHERE idUser=?;";
    private static String SQL_delete_User="DELETE FROM mydb.users WHERE idUser=?;";


    /**
     * Calculates total users number available in DB
     *
     * @return count of users in DB
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public Integer calculateUsersNumber() throws DataNotFoundException {
        return null;
    }

    /**
     * Finds all users in DB
     *
     * @return List of all users
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public List<User> findAllUsersInDB() throws DataNotFoundException {
        return null;
    }

    /**
     * Finds users in DB from
     *
     * @param first  first row number
     * @param offset offset
     * @return List users
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public List<User> findUsers(Integer first, Integer offset) throws DataNotFoundException {
        return null;
    }

    /**
     * Finds all users by user role
     *
     * @param role - User`s role
     * @return List of
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public List<User> findUserByRole(UserRole role) throws DataNotFoundException {
        return null;
    }

    /**
     * Finds user by user id number
     *
     * @param id - User`s id number
     * @return User
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public User findUserById(Integer id) throws DataNotFoundException {
        return null;
    }

    /**
     * Finds User by name
     *
     * @param name - User name
     * @return User by name
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public User findUserByName(String name) throws DataNotFoundException {
        return null;
    }

    /**
     * Adds new user to DB
     *
     * @param user - user to add in DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean addUserToDB(User user) {
        return false;
    }

    /**
     * Updats user in DB
     *
     * @param user - User to update in DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean updateUserInDB(User user) {
        return false;
    }

    /**
     * Deletes user from DB
     *
     * @param user - User to delete from DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean deleteUserFromDB(User user) {
        return false;
    }
}
