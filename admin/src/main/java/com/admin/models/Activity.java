package com.admin.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Activity {

    @Id
    @GeneratedValue
    private int id;
    private String action;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Activity(int id, String action) {
        this.id = id;
        this.action = action;
    }

    public Activity() {
    }

    public Activity(String action) {
        this.action = action;
    }

    public Activity(String action, Date date) {
        this.action = action;
        this.date = date;
    }
}
