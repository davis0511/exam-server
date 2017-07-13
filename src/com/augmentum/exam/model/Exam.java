package com.augmentum.exam.model;

import java.util.Date;

public class Exam {

    private int id;
    private String examName;
    private String description;
    private int totalScore;
    private int quanlity;
    private int examTime;
    private int singleScore;
    private Date createdTime;
    private Date updatedTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getExamName() {
        return examName;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public int getQuanlity() {
        return quanlity;
    }
    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }
    public int getExamTime() {
        return examTime;
    }
    public void setExamTime(int examTime) {
        this.examTime = examTime;
    }
    public int getSingleScore() {
        return singleScore;
    }
    public void setSingleScore(int singleScore) {
        this.singleScore = singleScore;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public Date getUpdatedTime() {
        return updatedTime;
    }
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
