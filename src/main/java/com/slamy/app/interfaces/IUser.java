package com.slamy.app.interfaces;

import com.slamy.app.models.Email;

public interface IUser {
    int getAge();
    void setAge(int age);

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    Email getEmail();
    void setEmail(Email email);

    String getPassword();
    void setPassword(String password);

    boolean getIsLoggedIn();
    void setIsLoggedIn(boolean isLoggedIn);
}
