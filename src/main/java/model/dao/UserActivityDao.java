package model.dao;

import exception.DataNotFoundException;
import model.entity.UserActivity;

import java.util.List;


/**
 * CRUD operations interface for Payment entity
 */

public interface UserActivityDao {


    /**
     * Finds all userActivity in DB
     * @return List of all activities
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    List<UserActivity> findAllUserActivityInDB() throws DataNotFoundException;

    /**
     * Finds UserActivity by userId
     * @param userId - UserActivity userId
     * @return UserActivity by userId
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    UserActivity findUserActivityByUserId(int userId) throws DataNotFoundException;
    /**
     * Finds UserActivity by activityId
     * @param activityId - UserActivity activityId
     * @return UserActivity by activityId
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    UserActivity findUserActivityByActivityId(int activityId) throws DataNotFoundException;
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
