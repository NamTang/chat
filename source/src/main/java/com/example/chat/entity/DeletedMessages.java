package com.example.chat.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deleted_messages", schema = "chat", catalog = "")
public class DeletedMessages {

    private long id;
    private long messagesId;
    private long usersId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

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
    @Column(name = "messages_id")
    public long getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(int messagesId) {
        this.messagesId = messagesId;
    }

    public void setMessagesId(long messagesId) {
        this.messagesId = messagesId;
    }

    @Basic
    @Column(name = "users_id")
    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
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
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DeletedMessages that = (DeletedMessages) o;
        return id == that.id && messagesId == that.messagesId && usersId == that.usersId && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messagesId, usersId, createdAt, updatedAt);
    }
}
