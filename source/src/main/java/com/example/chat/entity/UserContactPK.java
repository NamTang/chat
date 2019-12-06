package com.example.chat.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserContactPK implements Serializable {
    private long userId;
    private long contactId;

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "contact_id")
    @Id
    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserContactPK that = (UserContactPK) o;
        return userId == that.userId && contactId == that.contactId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, contactId);
    }
}
