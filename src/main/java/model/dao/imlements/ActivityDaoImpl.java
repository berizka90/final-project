package model.dao.imlements;

import exception.DataNotFoundException;
import model.dao.ActivityDao;
import model.dao.GenericAbstractDao;
import model.dao.Mapper;
import model.entity.Activity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static model.dao.DbConstants.*;


public class ActivityDaoImpl extends GenericAbstractDao<Activity> implements ActivityDao{
        private Connection connection;

    private Mapper<Activity, PreparedStatement> mapperToDb = (Activity activity, PreparedStatement ps) -> {
            ps.setString(1, activity.getName());
            ps.setString(2, activity.getDescription());
        };

    private Mapper<ResultSet, Activity> mapperFromDb = (ResultSet set, Activity activity) -> {
            activity.setIdActivity(set.getInt(ACTIVITY_ID));
            activity.setName(set.getString(ACTIVITY_NAME));
            activity.setDescription(set.getString(ACTIVITY_DESCRIPTION));
        };

    public ActivityDaoImpl(Connection connection) {
        super.setMapperToDb(mapperToDb);
        super.setMapperFromDb(mapperFromDb);
        this.connection = connection;
    }

    @Override
    public Integer calculateActivityNumber() throws DataNotFoundException {
        return calculateRowCounts(connection,ACTIVITY_TABLE);
    }


    @Override
    public List<Activity> findAllActivityInDB() throws DataNotFoundException {
        return findAll(connection,Activity.class,SQL_A_SELECT_ALL);
    }

    @Override
    public Activity findActivityByName(String name) throws DataNotFoundException {
        return findBy(connection, Activity.class, SQL_A_SELECT_BY_NAME,name);
    }

    @Override
    public boolean addActivityToDB(Activity activity) {
        return addToDB(connection,activity,SQL_A_ADD_NEW);
    }

    @Override
    public boolean updateActivityInDB(Activity activity) {
        return updateInDB(connection,activity,SQL_A_UPDATE_BY_ID,3,activity.getIdActivity());
    }

    @Override
    public boolean deleteActivityFromDB(Activity activity) {
        return deleteFromDB(connection,SQL_A_DELETE_ACTIVITY,activity.getIdActivity());
    }
}
