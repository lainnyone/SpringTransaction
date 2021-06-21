package model;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable {
    private int userDetailId;
    private String name;
    private String surname;
    private Date birthOfDate;

    public UserDetail(){}

    public UserDetail(int userDetailId, String name, String surname, Date birthOfDate) {
        this.userDetailId = userDetailId;
        this.name = name;
        this.surname = surname;
        this.birthOfDate = birthOfDate;
    }

    public int getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(int userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "userDetailId=" + userDetailId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthOfDate=" + birthOfDate +
                '}';
    }
}
