/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.11
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2019/12/06 AD at 10:50:58 ICT
*/
package com.example.chat.entity;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>
 * Title: Reports
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Reports entity
 * </p>
 *
 */
@Entity(name = "Reports")
@Table(name = "reports")
@NamedQueries({ @NamedQuery(name = Reports.FIND_ALL, query = "SELECT a FROM Reports a"),
        @NamedQuery(name = Reports.FIND_BY_REPORTTYPE, query = "SELECT a FROM Reports a WHERE a.reportType = :reportType"),
        @NamedQuery(name = Reports.FIND_BY_REPORTTYPE_CONTAINING, query = "SELECT a FROM Reports a WHERE a.reportType like :reportType"),
        @NamedQuery(name = Reports.FIND_BY_NOTES, query = "SELECT a FROM Reports a WHERE a.notes = :notes"),
        @NamedQuery(name = Reports.FIND_BY_NOTES_CONTAINING, query = "SELECT a FROM Reports a WHERE a.notes like :notes"),
        @NamedQuery(name = Reports.FIND_BY_STATUS, query = "SELECT a FROM Reports a WHERE a.status = :status"),
        @NamedQuery(name = Reports.FIND_BY_STATUS_CONTAINING, query = "SELECT a FROM Reports a WHERE a.status like :status"),
        @NamedQuery(name = Reports.FIND_BY_CREATEDAT, query = "SELECT a FROM Reports a WHERE a.createdAt = :createdAt") })

public class Reports implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String __DEFAULT_STATUS = new String("pending");
    public static final String FIND_ALL = "Reports.findAll";
    public static final String FIND_BY_REPORTTYPE = "Reports.findByReportType";
    public static final String FIND_BY_REPORTTYPE_CONTAINING = "Reports.findByReportTypeContaining";
    public static final String FIND_BY_NOTES = "Reports.findByNotes";
    public static final String FIND_BY_NOTES_CONTAINING = "Reports.findByNotesContaining";
    public static final String FIND_BY_STATUS = "Reports.findByStatus";
    public static final String FIND_BY_STATUS_CONTAINING = "Reports.findByStatusContaining";
    public static final String FIND_BY_CREATEDAT = "Reports.findByCreatedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @report_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @report_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-report_type@
    @Column(name = "report_type", length = 45, nullable = false, unique = false)
    private String reportType;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @notes-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @notes-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-notes@
    @Column(name = "notes", length = 65535, nullable = false, unique = false)
    private String notes;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @status-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @status-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-status@
    @Column(name = "status", length = 8, nullable = false, unique = false)
    private String status;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name = "created_at", nullable = false, unique = false)
    private Timestamp createdAt;
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participants_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Participants participantsId;

    @Column(name = "participants_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer participantsId_;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users usersId;

    @Column(name = "users_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer usersId_;

    /**
     * Default constructor
     */
    public Reports() {
    }

    /**
     * All field constructor
     */
    public Reports(Integer id, Integer usersId, Integer participantsId, String reportType, String notes, String status, Timestamp createdAt) {
        this(id, usersId, participantsId, reportType, notes, status, createdAt, true);
    }

    public Reports(Integer id, Integer usersId, Integer participantsId, String reportType, String notes, String status, Timestamp createdAt,
            boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setReportType(reportType);
        setNotes(notes);
        setStatus(status);
        setCreatedAt(createdAt);
        // parents
        if (setRelationship && participantsId != null) {
            this.participantsId = new Participants();
            this.participantsId.setId(participantsId);
            setParticipantsId_(participantsId);
        }
        if (setRelationship && usersId != null) {
            this.usersId = new Users();
            this.usersId.setId(usersId);
            setUsersId_(usersId);
        }
    }

    public Reports flat() {
        return new Reports(getId(), getUsersId_(), getParticipantsId_(), getReportType(), getNotes(), getStatus(), getCreatedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-report_type@
    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-notes@
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-status@
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_at@
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
//MP-MANAGED-UPDATABLE-ENDING

    public Participants getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(Participants participantsId) {
        this.participantsId = participantsId;
    }

    public Integer getParticipantsId_() {
        return participantsId_;
    }

    public void setParticipantsId_(Integer participantsId) {
        this.participantsId_ = participantsId;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    public Integer getUsersId_() {
        return usersId_;
    }

    public void setUsersId_(Integer usersId) {
        this.usersId_ = usersId;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-reports@
    @javax.persistence.PrePersist
    public void prePersist_() {
        if (status == null)
            status = __DEFAULT_STATUS;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-reports@
    @javax.persistence.PreUpdate
    public void preUpdate_() {
        if (status == null)
            status = __DEFAULT_STATUS;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
