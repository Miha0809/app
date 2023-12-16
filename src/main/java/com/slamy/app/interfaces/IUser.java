package com.slamy.app.interfaces;

import com.slamy.app.models.Email;

public interface IUser {
    public int getAge();
    public void setAge(int age);

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public Email getEmail();
    public void setEmail(Email email);

    public String getPassword();
    public void setPassword(String password);

}
