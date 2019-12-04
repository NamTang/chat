package com.example.chat.entity;


public class BlockList {

  private long id;
  private long usersId;
  private long participantsId;
  private java.sql.Timestamp createdAt;


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


  public long getParticipantsId() {
    return participantsId;
  }

  public void setParticipantsId(long participantsId) {
    this.participantsId = participantsId;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
