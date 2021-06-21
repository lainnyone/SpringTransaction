package model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int userId;
    private String username;
    private String password;
    private Date creationDate;
    private UserDetail userDetail;

    public User(int userId, String username, String password, Date creationDate){}

    public User(int userId, String username, String password, Date creationDate, UserDetail userDetail) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
