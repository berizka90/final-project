package model.dao.imlements;

import exception.DataNotFoundException;
import model.dao.GenericAbstractDao;
import model.dao.Mapper;
import model.dao.UserDao;
import model.entity.User;
import model.entity.UserRole;

import static model.dao.DbConstants.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl extends GenericAbstractDao<User> implements UserDao {
    private Connection connection;

    private Mapper<User, PreparedStatement> mapperToDb = (User user, PreparedStatement ps) -> {
        ps.setString(1, user.getName());
        ps.setString(2, user.getLogin());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getRole());
    };

    private Mapper<ResultSet, User> mapperFromDb = (ResultSet set, User user) -> {
        user.setIdUser(set.getInt(USERS_ID));
        user.setName(set.getString(USERS_NAME));
        user.setLogin(set.getString(USERS_LOGIN));
        user.setPassword(set.getString(USERS_PASSWORD));
        user.setRole(UserRole.valueOf(set.getString(USERS_ROLE)));
    };

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
        super.setMapperToDb(mapperToDb);
        super.setMapperFromDb(mapperFromDb);
    }


    @Override
    public Integer calculateUsersNumber() throws DataNotFoundException {
        return calculateRowCounts(connection, USERS_TABLE);
    }


    @Override
    public List<User> findAllUsersInDB() throws DataNotFoundException {
        return findAll(connection, User.class, SQL_U_SELECT_ALL);
    }

    @Override
    public List<User> findUsers(Integer first, Integer offset) throws DataNotFoundException {
        return findAllFromTo(connection, User.class, first, offset, SQL_U_SELECT_ALL);
    }

    @Override
    public List<User> findUserByRole(UserRole role) throws DataNotFoundException {
        return findAsListBy(connection, User.class, SQL_U_SELECT_BY_ROLE, role.toString());
    }

    @Override
    public User findUserById(Integer id) throws DataNotFoundException {
        return findBy(connection, User.class, SQL_U_SELECT_BY_ID, id);
    }

    @Override
    public User findUserByName(String name) throws DataNotFoundException {
        return findBy(connection, User.class, SQL_U_SELECT_BY_NAME, name);
    }

    @Override
    public boolean addUserToDB(User user) {
        return addToDB(connection, user, SQL_U_ADD_NEW);
    }

    @Override
    public boolean updateUserInDB(User user) {
        return updateInDB(connection, user, SQL_U_UPDATE_BY_ID, 5, user.getIdUser());
    }

    @Override
    public boolean deleteUserFromDB(User user) {
        return deleteFromDB(connection, SQL_U_DELETE_USER, user.getIdUser());
    }
}
