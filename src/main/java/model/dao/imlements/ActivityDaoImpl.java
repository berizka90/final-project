package model.dao.imlements;

import exception.DataNotFoundException;
import model.dao.ActivityDao;
import model.entity.Activity;

import java.util.List;

public class ActivityDaoImpl implements ActivityDao {
    /**
     * Calculates total activity number available in DB
     *
     * @return count of activity in DB
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public Integer calculateActivityNumber() throws DataNotFoundException {
        return null;
    }

    /**
     * Finds all activity in DB
     *
     * @return List of all activities
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public List<Activity> findAllActivityInDB() throws DataNotFoundException {
        return null;
    }

    /**
     * Finds Activity by name
     *
     * @param name - Activity name
     * @return Activity by name
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    @Override
    public Activity findActivityByName(String name) throws DataNotFoundException {
        return null;
    }

    /**
     * Adds new activity to DB
     *
     * @param activity - activity to add in DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean addActivityToDB(Activity activity) {
        return false;
    }

    /**
     * Updats activity in DB
     *
     * @param activity - activity to update in DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean updateActivityInDB(Activity activity) {
        return false;
    }

    /**
     * Deletes activity from DB
     *
     * @param activity - Activity to delete from DB
     * @return true if operation success and false if fails
     */
    @Override
    public boolean deleteActivityFromDB(Activity activity) {
        return false;
    }
}
