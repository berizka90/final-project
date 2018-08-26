package model.dao.imlements;

import exception.DataNotFoundException;
import model.dao.UserActivityDao;
import model.entity.UserActivity;

import java.util.List;

public class UserActivityDaoImpl implements UserActivityDao {
    /**
     * Calculates total userActivity number available in DB
     *
     * @return count of userActivity in DB
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public Integer calculateUserActivityNumber() throws DataNotFoundException {
        return null;
    }

    /**
     * Finds all userActivity in DB
     *
     * @return List of all activities
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public List<UserActivity> findAllUserActivityInDB() throws DataNotFoundException {
        return null;
    }

    /**
     * Finds UserActivity by name
     *
     * @param name - UserActivity name
     * @return UserActivity by name
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public UserActivity findUserActivityByName(String name) throws DataNotFoundException {
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
