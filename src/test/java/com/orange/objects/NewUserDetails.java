package com.orange.objects;

public class NewUserDetails {

    String employeeName;
    String userName;
    String password;
    String cnfPassword;
    String userRole;
    String status;

    public NewUserDetails(){}

    public NewUserDetails(String userRole, String status, String employeeName, String userName, String password, String cnfPassword){
        this.userRole=userRole;
        this.status=status;
        this.employeeName=employeeName;
        this.userName= userName;
        this.password=password;
        this.cnfPassword=cnfPassword;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCnfPassword() {
        return cnfPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getStatus() {
        return status;
    }
}
