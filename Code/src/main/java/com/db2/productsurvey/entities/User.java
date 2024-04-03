package com.db2.productsurvey.entities;

import javax.persistence.*;

import static javax.persistence.InheritanceType.SINGLE_TABLE;


@NamedQuery(name="User.checkCredentials",
        query="SELECT u FROM User u WHERE u.username=:username AND u.password=:password"
)

@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name= "ISADMIN")

@Table(uniqueConstraints={@UniqueConstraint(columnNames = "email")})
@Entity
public class User {
    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique=true)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
