package com.slamy.app.models;

import com.slamy.app.interfaces.IEmail;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Email")
@Table(
        name = "emails",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_name_unique", columnNames = "name")
        }
)
public class Email implements IEmail {
    @Id
    @SequenceGenerator(
            name = "email_sequence",
            sequenceName = "email_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "email_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Email() { }

    public Email(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

