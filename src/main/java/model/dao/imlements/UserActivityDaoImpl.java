package model.dao.imlements;

import exception.DataNotFoundException;
import model.dao.GenericAbstractDao;
import model.dao.Mapper;
import model.dao.UserActivityDao;
import model.entity.UserActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static model.dao.DbConstants.*;

public class UserActivityDaoImpl extends GenericAbstractDao<UserActivity> implements UserActivityDao {
    private Connection connection;

    private Mapper<UserActivity, PreparedStatement> mapperToDb = (UserActivity userActivity, PreparedStatement ps) -> {
        ps.setInt(1, userActivity.getUserId());
        ps.setInt(2, userActivity.getActivityId());
        ps.setInt(3, userActivity.getTime());
        ps.setString(4,userActivity.getStatus());
    };

    private Mapper<ResultSet, UserActivity> mapperFromDb = (ResultSet set, UserActivity userActivity) -> {
        userActivity.setId(set.getInt(UA_ID));
        userActivity.setUserId(set.getInt(UA_ID_USER));
        userActivity.setActivityId(set.getInt(UA_ID_ACTIVITY));
        userActivity.setTime(set.getInt(UA_TIME));
        userActivity.setStatus(UserActivity.Status.valueOf(set.getString(UA_STATUS)));
    };

    public UserActivityDaoImpl(Connection connection) {
        super.setMapperToDb(mapperToDb);
        super.setMapperFromDb(mapperFromDb);
        this.connection = connection;
    }

    @Override
    public List<UserActivity> findAllUserActivityInDB() throws DataNotFoundException {
        return findAll(connection,UserActivity.class,SQL_UA_SELECT_ALL_JOIN);
    }


    /**To do*/

    @Override
    public UserActivity findUserActivityByUserId(int userId) throws DataNotFoundException {
        return null;
    }

    /**
     * Finds UserActivity by activityId
     *
     * @param activityId - UserActivity activityId
     * @return UserActivity by activityId
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public UserActivity findUserActivityByActivityId(int activityId) throws DataNotFoundException {
        return null;
    }

    /**
     * Adds new userActivity to DB
     *
     * @param userActivity - userActivity to add in DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean addUserActivityToDB(UserActivity userActivity) {
        return false;
    }

    /**
     * Updats userActivity in DB
     *
     * @param userActivity - userActivity to update in DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean updateUserActivityInDB(UserActivity userActivity) {
        return false;
    }

    /**
     * Deletes userActivity from DB
     *
     * @param userActivity - UserActivity to delete from DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean deleteUserActivityFromDB(UserActivity userActivity) {
        return false;
    }
}
