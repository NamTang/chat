package com.example.chat.entity;


public class Access {

  private long id;
  private long usersId;
  private long devicesId;
  private String token;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp deletedAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUsersId() {
    return usersId;
  }

  public void setUsersId(long usersId) {
    this.usersId = usersId;
  }


  public long getDevicesId() {
    return devicesId;
  }

  public void setDevicesId(long devicesId) {
    this.devicesId = devicesId;
  }


  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(java.sql.Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }

}
