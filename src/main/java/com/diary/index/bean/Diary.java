package com.diary.index.bean;


import java.util.Date;

public class Diary {

  private int id;
  private String content;
  private Date updateTime;
  private String color;
  private int top;
  private String remind;
  private Date remindTime;
  private String emailRemind;
  private String status;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  public int getTop() {
    return top;
  }

  public void setTop(int top) {
    this.top = top;
  }


  public String getRemind() {
    return remind;
  }

  public void setRemind(String remind) {
    this.remind = remind;
  }


  public Date getRemindTime() {
    return remindTime;
  }

  public void setRemindTime(Date remindTime) {
    this.remindTime = remindTime;
  }


  public String getEmailRemind() {
    return emailRemind;
  }

  public void setEmailRemind(String emailRemind) {
    this.emailRemind = emailRemind;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
