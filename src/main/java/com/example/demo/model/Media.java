package com.example.demo.model;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Media implements Serializable {
    /**
     * fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotNull
    private String author;
    private String name;
    private String type;
    private String userBorrowed;
    private int timesBorrowed;

    /**
     * constructors
     */
    public Media() { }
    public Media(Long id, String name, String type, String userBorrowed, int timesBorrowed) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.userBorrowed = userBorrowed;
        this.timesBorrowed = timesBorrowed;
    }

    /**
     * getters and setters
     */
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getUserBorrowed() {
        return userBorrowed;
    }
    public int getTimesBorrowed() {
        return timesBorrowed;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setUserBorrowed(String userBorrowed) {
        this.userBorrowed = userBorrowed;
    }
    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", userBorrowed='" + userBorrowed + '\'' +
                ", timesBorrowed=" + timesBorrowed +
                '}';
    }

}


//    @Column(nullable = false, updatable = false)
//    private String MediaCode;
//    public String getMediaCode() {
//        return MediaCode;
//    }

//    public void setMediaCode(String MediaCode) {
//        this.MediaCode = MediaCode;
//    }