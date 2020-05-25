package com.example.HibernateDemo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    private Integer id;

    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    private LocalDateTime postDate;

    @ManyToOne
    @JoinColumn(name = "userid",insertable=false,updatable = false)
    private User user;

    private String details;

    public Post() {
    }

    public Post(Integer id, LocalDateTime postDate, User user, String details) {
        this.id=id;
        this.postDate=postDate;
        this.user=user;
        this.details=details;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
