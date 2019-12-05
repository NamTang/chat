package com.example.chat.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reports {

    private long id;
    private long usersId;
    private long participantsId;
    private String reportType;
    private String notes;
    private String status;
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
    @Column(name = "report_type")
    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = (String) status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Reports reports = (Reports) o;
        return id == reports.id && usersId == reports.usersId && participantsId == reports.participantsId
                && Objects.equals(reportType, reports.reportType) && Objects.equals(notes, reports.notes) && Objects.equals(status, reports.status)
                && Objects.equals(createdAt, reports.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usersId, participantsId, reportType, notes, status, createdAt);
    }
}
