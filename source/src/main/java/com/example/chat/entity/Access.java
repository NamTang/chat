package com.example.chat.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Access {

    private long id;
    private long usersId;
    private long devicesId;
    private String token;
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
    @Column(name = "devices_id")
    public long getDevicesId() {
        return devicesId;
    }

    public void setDevicesId(int devicesId) {
        this.devicesId = devicesId;
    }

    public void setDevicesId(long devicesId) {
        this.devicesId = devicesId;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        Access access = (Access) o;
        return id == access.id && usersId == access.usersId && devicesId == access.devicesId && Objects.equals(token, access.token)
                && Objects.equals(createdAt, access.createdAt) && Objects.equals(deletedAt, access.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersId, devicesId, token, createdAt, deletedAt);
    }
}
