package model.dao;

import exception.DataBaseConnectionException;
import model.dao.imlements.ActivityDaoImpl;
import model.dao.imlements.UserActivityDaoImpl;
import model.dao.imlements.UserDaoImpl;
import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private static DataSource dataSource;
    private static final Logger log = Logger.getLogger(JDBCDaoFactory.class);
    private Connection connection;


    JDBCDaoFactory() throws NamingException {

        InitialContext ic = new InitialContext();
        dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/mydb");

    }

    private Connection getConnection() throws DataBaseConnectionException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error(e);
            throw new DataBaseConnectionException();
        }
    }

    /**
     * transaction methods
     */
    @Override
    public void beginTransaction() throws DataBaseConnectionException {
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            log.error(e);
            throw new DataBaseConnectionException();
        }
    }

    @Override
    public void commitTransaction() throws DataBaseConnectionException {
        try {
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            log.error(e);
            throw new DataBaseConnectionException();
        }
    }

    @Override
    public void rollbackTransaction() throws DataBaseConnectionException {
        try {
            connection.rollback();
            connection.close();
        } catch (SQLException e) {
            log.error(e);
            throw new DataBaseConnectionException();
        }
    }
    /** Connection open and closing methods */
    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void open() throws DataBaseConnectionException {
        connection = getConnection();
    }

   /** get Dao */
    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    @Override
    public ActivityDao getActivityDao() {
        return new ActivityDaoImpl();
    }

    @Override
    public UserActivityDao getUserActivityDao() {
        return new UserActivityDaoImpl();
    }




}


