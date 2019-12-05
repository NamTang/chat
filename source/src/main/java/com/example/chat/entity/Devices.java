package com.example.chat.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Devices {

    private long id;
    private long usersId;
    private String deviceId;
    private String type;
    private String deviceToken;
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
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = (String) type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "device_token")
    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
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
        Devices devices = (Devices) o;
        return id == devices.id && usersId == devices.usersId && Objects.equals(deviceId, devices.deviceId) && Objects.equals(type, devices.type)
                && Objects.equals(deviceToken, devices.deviceToken) && Objects.equals(createdAt, devices.createdAt)
                && Objects.equals(updatedAt, devices.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersId, deviceId, type, deviceToken, createdAt, updatedAt);
    }
}
