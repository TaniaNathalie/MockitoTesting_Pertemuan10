package org.example;

public class User {
    public String getPassword() {
        return passwordMd5;
    }

    public void setPassword(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    String passwordMd5;
//    void setPassword(String passwordMd5);
//
//    Object getPassword();
}
