package com.example.chat.entity;


public class Messages {

  private long id;
  private String guid;
  private long conversationId;
  private long senderId;
  private String messageType;
  private String message;
  private String attachmentThumbUrl;
  private String attachmentUrl;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp deletedAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }


  public long getConversationId() {
    return conversationId;
  }

  public void setConversationId(long conversationId) {
    this.conversationId = conversationId;
  }


  public long getSenderId() {
    return senderId;
  }

  public void setSenderId(long senderId) {
    this.senderId = senderId;
  }


  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public String getAttachmentThumbUrl() {
    return attachmentThumbUrl;
  }

  public void setAttachmentThumbUrl(String attachmentThumbUrl) {
    this.attachmentThumbUrl = attachmentThumbUrl;
  }


  public String getAttachmentUrl() {
    return attachmentUrl;
  }

  public void setAttachmentUrl(String attachmentUrl) {
    this.attachmentUrl = attachmentUrl;
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
