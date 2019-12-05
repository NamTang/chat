package com.example.chat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "deleted_conversations", schema = "chat", catalog = "")
public class DeletedConversations {

    private long id;
    private long conversationId;
    private long usersId;
    private Timestamp createdAt;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DeletedConversations that = (DeletedConversations) o;
        return id == that.id && conversationId == that.conversationId && usersId == that.usersId && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conversationId, usersId, createdAt);
    }
}
