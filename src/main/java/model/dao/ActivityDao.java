package model.dao;

        import exception.DataNotFoundException;
        import model.entity.Activity;

        import java.util.List;

/**
 * CRUD opeations interface for Payment entity
 */
public interface ActivityDao {
    /**
     * Calculates total activity number available in DB
     * @return count of activity in DB
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    Integer calculateActivityNumber() throws DataNotFoundException;

    /**
     * Finds all activity in DB
     * @return List of all activities
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    List<Activity> findAllActivityInDB() throws DataNotFoundException;

    /**
     * Finds Activity by name
     * @param name - Activity name
     * @return Activity by name
     * @throws DataNotFoundException if connection is down, broken or unable to retrieve information for certain reasons
     */
    Activity findActivityByName(String name) throws DataNotFoundException;

    /**
     * Adds new activity to DB
     * @param activity - activity to add in DB
     * @return true if operation success and false if fails
     */
    boolean addActivityToDB(Activity activity);

    /**
     * Updats activity in DB
     * @param activity - activity to update in DB
     * @return true if operation success and false if fails
     */
    boolean updateActivityInDB(Activity activity);

    /**
     * Deletes activity from DB
     * @param activity - Activity to delete from DB
     * @return true if operation success and false if fails
     */
    boolean deleteActivityFromDB(Activity activity);
}

