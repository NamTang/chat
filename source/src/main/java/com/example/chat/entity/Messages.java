package com.example.chat.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Messages {

    private long id;
    private String guid;
    private long conversationId;
    private long senderId;
    private String messageType;
    private String message;
    private String attachmentThumbUrl;
    private String attachmentUrl;
    private Timestamp createdAt;
    private Timestamp deletedAt;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "conversation_id")
    public long getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }

    @Basic
    @Column(name = "sender_id")
    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "message_type")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(Object messageType) {
        this.messageType = (String) messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "attachment_thumb_url")
    public String getAttachmentThumbUrl() {
        return attachmentThumbUrl;
    }

    public void setAttachmentThumbUrl(String attachmentThumbUrl) {
        this.attachmentThumbUrl = attachmentThumbUrl;
    }

    @Basic
    @Column(name = "attachment_url")
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Messages messages = (Messages) o;
        return id == messages.id && conversationId == messages.conversationId && senderId == messages.senderId && Objects.equals(guid, messages.guid)
                && Objects.equals(messageType, messages.messageType) && Objects.equals(message, messages.message)
                && Objects.equals(attachmentThumbUrl, messages.attachmentThumbUrl) && Objects.equals(attachmentUrl, messages.attachmentUrl)
                && Objects.equals(createdAt, messages.createdAt) && Objects.equals(deletedAt, messages.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guid, conversationId, senderId, messageType, message, attachmentThumbUrl, attachmentUrl, createdAt, deletedAt);
    }
}
