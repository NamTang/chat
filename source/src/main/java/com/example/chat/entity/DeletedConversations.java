package com.example.chat.entity;


public class DeletedConversations {

  private long id;
  private long conversationId;
  private long usersId;
  private java.sql.Timestamp createdAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getConversationId() {
    return conversationId;
  }

  public void setConversationId(long conversationId) {
    this.conversationId = conversationId;
  }


  public long getUsersId() {
    return usersId;
  }

  public void setUsersId(long usersId) {
    this.usersId = usersId;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
