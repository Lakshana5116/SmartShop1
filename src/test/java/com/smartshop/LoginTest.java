package com.smartshop;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testValidLogin() {

        Login login = new Login();

        assertTrue(login.checkLogin("admin", "admin1234"));
    }

    @Test
    public void testInvalidLogin() {

        Login login = new Login();

        assertFalse(login.checkLogin("admin", "wrongpassword"));
    }
}