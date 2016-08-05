package com.jack.mc.cyg.retrofittestproject.model;

import java.io.Serializable;

/**
 *
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String picSmall;
    private String picBig;
    private String description;
    private Integer learner;

    public Item() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicBig() {
        return picBig;
    }

    public void setPicBig(String picBig) {
        this.picBig = picBig;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLearner() {
        return learner;
    }

    public void setLearner(Integer learner) {
        this.learner = learner;
    }
}
