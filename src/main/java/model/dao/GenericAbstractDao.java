package model.dao;

import exception.DataNotFoundException;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class GenericAbstractDao<T>  {
    private Mapper<T, PreparedStatement> mapperToDb;
    private Mapper<ResultSet,T> mapperFromDb;

    private static final Logger log=Logger.getLogger(GenericAbstractDao.class);

    public GenericAbstractDao() {
    }

    public void setMapperToDb(Mapper<T, PreparedStatement> mapperToDb) {
        this.mapperToDb = mapperToDb;
    }

    public void setMapperFromDb(Mapper<ResultSet, T> mapperFromDb) {
        this.mapperFromDb = mapperFromDb;
    }

    protected List<T> findAll(Connection connection, Class t, String SQLgetAll)throws DataNotFoundException{
        List<T> items=new LinkedList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(SQLgetAll);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
               T item=getItemInstance(t);
               mapperFromDb.map(resultSet,item);
               items.add(item);
            }
        } catch (SQLException e) {
            throw new DataNotFoundException();
        }
        return items;
    }
    protected List<T> findAllFromTo(Connection connection, Class t, Integer first, Integer offset, String SQL_getAll_base)
            throws DataNotFoundException {
        List<T> items = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_getAll_base + " limit " + first + ", " + offset + ";");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                T item = getItemInstance(t);
                mapperFromDb.map(resultSet, item);
                items.add(item);
            }
        } catch (SQLException sqle) {
            throw new DataNotFoundException();
        }
        return items;
    }

    protected <V> T findBy(Connection connection, Class t, String SQL_selectByParameter, V value)
            throws DataNotFoundException {
        T item = getItemInstance(t);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_selectByParameter);
            addParameterToPreparedStatement(preparedStatement, 1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                mapperFromDb.map(resultSet, item);
            else
                throw new DataNotFoundException();
        } catch (SQLException sqle) {
            log.error(sqle);
            throw new DataNotFoundException();
        }
        return item;
    }

    protected <V> List<T> findAsListBy(Connection connection, Class t, String SQL_selectByParameter, V value)
            throws DataNotFoundException {
        List<T> items = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_selectByParameter);
            addParameterToPreparedStatement(preparedStatement, 1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T item = getItemInstance(t);
                mapperFromDb.map(resultSet, item);
                items.add(item);
            }
        } catch (SQLException sqle) {
            log.error(sqle);
            throw new DataNotFoundException();
        }
        return items;
    }

    protected boolean addToDB(Connection connection, T item, String SQL_addNew) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_addNew);
            mapperToDb.map(item, preparedStatement);
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqle) {
            log.error(sqle);
            return false;
        }
        return result;
    }

    protected <V> boolean updateInDB(Connection connection, T item, String SQL_update, Integer paramNum, V value) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_update);
            mapperToDb.map(item, preparedStatement);
            addParameterToPreparedStatement(preparedStatement, paramNum, value);
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqle) {
            log.error(sqle);
            return false;
        }
        return result;
    }

    protected <V> boolean deleteFromDB(Connection connection, String SQL_delete, V value) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_delete);
            addParameterToPreparedStatement(preparedStatement, 1, value);
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqle) {
            log.error(sqle);
            return false;
        }
        return result;
    }

    /** Method for table row count calculation. Used for pagination */
    public Integer calculateRowCounts(Connection connection, String tableName) throws DataNotFoundException {
        Integer result = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) AS ROWCOUNT FROM " + tableName + ";");
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("ROWCOUNT");
            }
        } catch (SQLException sqle) {
            throw new DataNotFoundException();
        }
        return result;
    }



    private <V> void addParameterToPreparedStatement(PreparedStatement preparedStatement, Integer paramNum, V value)
            throws SQLException {
        if (value instanceof String)
            preparedStatement.setString(paramNum, (String) value);
        if (value instanceof Integer)
            preparedStatement.setInt(paramNum, (Integer) value);

    }
    /** Private method witch returns a concrete instance on entity */
    private T getItemInstance(Class t) {
        T item = null;
        try {
            item = (T) t.newInstance();
        } catch (InstantiationException | IllegalAccessException ie) {
            log.error(ie);
        }
        return item;
    }
}
