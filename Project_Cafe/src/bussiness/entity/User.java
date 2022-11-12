package bussiness.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class User implements Serializable {
    private int userID;
    private String userName;
    private String password;
    private String confirmPassword;
    private String fullName;
    private LocalDate dateRegister;
    private boolean userStatus;
    private boolean permission;
    private String email;
    private String phoneNumber;

    public User() {
    }
    public User(String userName, String password, String confirmPassword, String fullName , LocalDate dateRegister, boolean userStatus, boolean permission, String email, String phoneNumber) {

        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        this.dateRegister = dateRegister;
        this.userStatus = userStatus;
        this.permission = permission;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
