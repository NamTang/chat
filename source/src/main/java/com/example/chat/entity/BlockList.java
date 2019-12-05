package com.example.chat.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "block_list", schema = "chat", catalog = "")
public class BlockList {

    private long id;
    private long usersId;
    private long participantsId;
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
    @Column(name = "participants_id")
    public long getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(int participantsId) {
        this.participantsId = participantsId;
    }

    public void setParticipantsId(long participantsId) {
        this.participantsId = participantsId;
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
        BlockList blockList = (BlockList) o;
        return id == blockList.id && usersId == blockList.usersId && participantsId == blockList.participantsId
                && Objects.equals(createdAt, blockList.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersId, participantsId, createdAt);
    }
}
