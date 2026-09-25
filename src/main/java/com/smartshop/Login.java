package com.smartshop;

public class Login {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin1234";

    public boolean checkLogin(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}