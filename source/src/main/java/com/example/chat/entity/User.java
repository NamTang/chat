package com.example.chat.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
    private int id;
    private String phone;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private byte isActive;
    private byte isReported;
    private byte isBlocked;
    private String preferences;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "is_active")
    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "is_reported")
    public byte getIsReported() {
        return isReported;
    }

    public void setIsReported(byte isReported) {
        this.isReported = isReported;
    }

    @Basic
    @Column(name = "is_blocked")
    public byte getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(byte isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Basic
    @Column(name = "preferences")
    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
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
        User users = (User) o;
        return id == users.id && isActive == users.isActive && isReported == users.isReported && isBlocked == users.isBlocked
                && Objects.equals(phone, users.phone) && Objects.equals(email, users.email) && Objects.equals(password, users.password)
                && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName)
                && Objects.equals(middleName, users.middleName) && Objects.equals(preferences, users.preferences)
                && Objects.equals(createdAt, users.createdAt) && Objects.equals(updatedAt, users.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, email, password, firstName, lastName, middleName, isActive, isReported, isBlocked, preferences, createdAt,
                updatedAt);
    }
}
