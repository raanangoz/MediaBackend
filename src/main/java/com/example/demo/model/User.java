package com.example.demo.model;

import com.example.demo.Security.PasswordConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    private String password;
    private String username;
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "user_groups",
            joinColumns ={@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
            )
    private Set<Group> userGroups = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(){
    }
    public User(Long id, String email, String password, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        PasswordEncoder p = new BCryptPasswordEncoder();

        this.password = p.encode(password);
    }

    public Set<Group> getUserGroups() {
        return userGroups;
    }
    public void addUserGroups(Group group){
        userGroups.add(group);
        group.getUsers().add(this);
    }

    public void removeUserGroups(Group group){
        userGroups.remove(group);
        group.getUsers().remove(this);
    }
}
