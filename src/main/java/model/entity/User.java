package model.entity;


import java.io.Serializable;

public class User implements Serializable {

    private Integer idUser;
    private String name;
    private String login;
    private String password;
    private UserRole role;

    public Integer getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role.toString();
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (!(obj instanceof User)) return false;
        User user=(User) obj;
        return  (this.login.equals(user.login) && (this.password.equals(user.password)));
    }

    @Override
    public int hashCode() {
        int result=login.hashCode();
        return 31*result + password.hashCode();
    }


    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
