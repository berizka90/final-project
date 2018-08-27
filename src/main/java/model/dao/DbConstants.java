package model.dao;

public interface DbConstants {
     String USERS_TABLE="users";
     String USERS_ID="idUser";
     String USERS_NAME="name";
     String USERS_LOGIN="login";
     String USERS_PASSWORD="password";
     String USERS_ROLE="role";

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
}
