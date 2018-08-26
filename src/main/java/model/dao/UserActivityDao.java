package model.dao;

import exception.DataNotFoundException;
import model.entity.UserActivity;

import java.util.List;


/**
 * CRUD operations interface for Payment entity
 */

public interface UserActivityDao {
    /**
     * Calculates total userActivity number available in DB
     * @return count of userActivity in DB
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    Integer calculateUserActivityNumber() throws DataNotFoundException;

    /**
     * Finds all userActivity in DB
     * @return List of all activities
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    List<UserActivity> findAllUserActivityInDB() throws DataNotFoundException;

    /**
     * Finds UserActivity by name
     * @param name - UserActivity name
     * @return UserActivity by name
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    UserActivity findUserActivityByName(String name) throws DataNotFoundException;

    /**
     * Adds new userActivity to DB
     * @param userActivity - userActivity to add in DB
     * @return true if operation success and false if fails
     */
    boolean addUserActivityToDB(UserActivity userActivity);

    /**
     * Updats userActivity in DB
     * @param userActivity - userActivity to update in DB
     * @return true if operation success and false if fails
     */
    boolean updateUserActivityInDB(UserActivity userActivity);

    /**
     * Deletes userActivity from DB
     * @param userActivity - UserActivity to delete from DB
     * @return true if operation success and false if fails
     */
    boolean deleteUserActivityFromDB(UserActivity userActivity);
}
