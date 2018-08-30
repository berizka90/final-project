package model.dao;


import exception.DataBaseConnectionException;

import javax.naming.NamingException;

public abstract class DaoFactory {

    private static DaoFactory daoFactory;
    /** Dao Factory methods
     * create User DAO
     * @return User DAO
     */
    public abstract UserDao getUserDao();

    /** create Activity DAO
     * @return Activity DAO
     */
    public abstract ActivityDao getActivityDao();

    /** create UserActivity Dao
     * @return UserActivity Dao
     */
    public abstract UserActivityDao getUserActivityDao();

    /**
     * Opens connection to Data Source
     * @throws DataBaseConnectionException if unable to open connection
     */
    public abstract void open() throws DataBaseConnectionException;

    /**
     * Closes connection to Data Source
     */
    public abstract void close();

    /**
     * Opens DB data transaction
     * @throws DataBaseConnectionException if unable to open data transaction
     */
    public abstract void beginTransaction() throws DataBaseConnectionException;

    /**
     * Commits transaction results and closes transaction
     * @throws DataBaseConnectionException if unable to commit data transaction
     */
    public abstract void commitTransaction() throws DataBaseConnectionException;

    /**
     * Rollbacks transaction results and closes transaction
     * @throws DataBaseConnectionException if unable to rollback transaction
     */
    public abstract void rollbackTransaction() throws DataBaseConnectionException;


    /** create JDBC DAO Factory as Singletone
     * @return  JDBC DaoFactory
     */

    public static DaoFactory getDaoFactory() throws NamingException {

        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                   daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
