package com.slamy.app.models;

import com.slamy.app.interfaces.IUser;
import com.slamy.app.services.Hash;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "User")
@Table(name = "users")
public class User implements IUser {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "first_name", nullable = false)
    private String firstName = "";
    @Column(name = "last_name", nullable = false)
    private String lastName = "";
    @Column(name = "password", nullable = false)
    private String password = "";

    @Column(name = "is_logged_in", nullable = false)
    private boolean isLoggedIn = false;

    @OneToOne
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email = null;

    public User() { }

    public User(int age,
                String firstName,
                String lastName,
                Email email,
                String password) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Email getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = Hash.getHash(password);
    }

    @Override
    public boolean getIsLoggedIn() {
        return this.isLoggedIn;
    }

    @Override
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isLoggedIn=" + isLoggedIn + '\'' +
                '}';
    }
}
