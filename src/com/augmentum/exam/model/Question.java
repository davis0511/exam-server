package com.augmentum.exam.model;

import java.util.Date;

public class Question {

    private int id;
    private String questionTitle;
    private String standardAnswer;
    private boolean isDelete;
    private String selectA;
    private String selectB;
    private String selectC;
    private String selectD;
    private Date createdTime;
    private Date updatedTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestionTitle() {
        return questionTitle;
    }
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    public String getStandardAnswer() {
        return standardAnswer;
    }
    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }
    public boolean getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    public String getSelectA() {
        return selectA;
    }
    public void setSelectA(String selectA) {
        this.selectA = selectA;
    }
    public String getSelectB() {
        return selectB;
    }
    public void setSelectB(String selectB) {
        this.selectB = selectB;
    }
    public String getSelectC() {
        return selectC;
    }
    public void setSelectC(String selectC) {
        this.selectC = selectC;
    }
    public String getSelectD() {
        return selectD;
    }
    public void setSelectD(String selectD) {
        this.selectD = selectD;
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

    @Override
    public String toString() {
        return "id=" + id + ", questionTitle=" + questionTitle +
               ", standardAnswer=" + standardAnswer + ", isDelete" + isDelete +
               ", selectA=" + selectA + ", selectB=" + selectB +
               ", selectC=" + selectC + ", selectD=" + selectD +
               ", createdTime" + createdTime + ", updatedTime=" + updatedTime;
    }
}
