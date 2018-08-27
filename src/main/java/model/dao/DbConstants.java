package model.dao;

public interface DbConstants {
    /** name of column of table*/

     String USERS_TABLE="users";
     String USERS_ID="idUser";
     String USERS_NAME="name";
     String USERS_LOGIN="login";
     String USERS_PASSWORD="password";
     String USERS_ROLE="role";

    String ACTIVITY_TABLE="activity";
    String ACTIVITY_ID="idActivity";
    String ACTIVITY_NAME="name";
    String ACTIVITY_DESCRIPTION="description";

    String USERS_ACTIVITY_TABLE="users_has_activity";
    String UA_ID="id";
    String UA_ID_USER="User_idUser";
    String UA_ID_ACTIVITY="Activity_idActivity";
    String UA_TIME="time";
    String UA_STATUS="status";


     /** SQL from table users */
     String SQL_U_SELECT_ALL="SELECT * FROM users;";
     String SQL_U_SELECT_BY_ID="SELECT * FROM users WHERE idUser=?;";
     String SQL_U_SELECT_BY_NAME="SELECT * FROM users WHERE name=?;";
     String SQL_U_SELECT_BY_ROLE="SELECT * FROM users WHERE role=?;";
     String SQL_U_ADD_NEW="INSERT INTO mydb.users (name,login, password, " +
             "role) VALUES (?,?,?,?);";
     String SQL_U_UPDATE_BY_ID="UPDATE mydb.users SET name=?," +
            "login=?, password=? WHERE idUser=?;";
    String SQL_U_DELETE_USER="DELETE FROM mydb.users WHERE idUser=?;";

    /** SQL from table activity */
    String SQL_A_SELECT_ALL="SELECT * FROM activity;";
    String SQL_A_SELECT_BY_NAME="SELECT * FROM activity WHERE name=?;";
    String SQL_A_ADD_NEW="INSERT INTO mydb.activity (name,description)" +
            " VALUES (?,?);";
    String SQL_A_UPDATE_BY_ID="UPDATE mydb.activity SET name=?," +
            " description=? WHERE idActivity=?;";
    String SQL_A_DELETE_ACTIVITY="DELETE FROM mydb.activity WHERE idActivity=?;";

    /** SQL from table users_has_activity */
    String SQL_UA_SELECT_ALL_JOIN="SELECT * FROM users_has_activity left join" +
            " users ON users_has_activity.Users_idUser=users.idUsers;";
}
