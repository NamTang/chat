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
	* - time      : 2019/12/06 AD at 10:50:57 ICT
*/
package com.example.chat.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>
 * Title: Activities
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Activities entity
 * </p>
 *
 */
@Entity(name = "Activities")
@Table(name = "activities")
@NamedQueries({ @NamedQuery(name = Activities.FIND_ALL, query = "SELECT a FROM Activities a"),
        @NamedQuery(name = Activities.FIND_BY_ACTIVITYTYPE, query = "SELECT a FROM Activities a WHERE a.activityType = :activityType"),
        @NamedQuery(name = Activities.FIND_BY_ACTIVITYTYPE_CONTAINING, query = "SELECT a FROM Activities a WHERE a.activityType like :activityType"),
        @NamedQuery(name = Activities.FIND_BY_ACTIVITYID, query = "SELECT a FROM Activities a WHERE a.activityId = :activityId"),
        @NamedQuery(name = Activities.FIND_BY_TITLE, query = "SELECT a FROM Activities a WHERE a.title = :title"),
        @NamedQuery(name = Activities.FIND_BY_TITLE_CONTAINING, query = "SELECT a FROM Activities a WHERE a.title like :title"),
        @NamedQuery(name = Activities.FIND_BY_DETAIL, query = "SELECT a FROM Activities a WHERE a.detail = :detail"),
        @NamedQuery(name = Activities.FIND_BY_DETAIL_CONTAINING, query = "SELECT a FROM Activities a WHERE a.detail like :detail"),
        @NamedQuery(name = Activities.FIND_BY_CREATEDAT, query = "SELECT a FROM Activities a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Activities.FIND_BY_UPDATEDAT, query = "SELECT a FROM Activities a WHERE a.updatedAt = :updatedAt") })

public class Activities implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Activities.findAll";
    public static final String FIND_BY_ACTIVITYTYPE = "Activities.findByActivityType";
    public static final String FIND_BY_ACTIVITYTYPE_CONTAINING = "Activities.findByActivityTypeContaining";
    public static final String FIND_BY_ACTIVITYID = "Activities.findByActivityId";
    public static final String FIND_BY_TITLE = "Activities.findByTitle";
    public static final String FIND_BY_TITLE_CONTAINING = "Activities.findByTitleContaining";
    public static final String FIND_BY_DETAIL = "Activities.findByDetail";
    public static final String FIND_BY_DETAIL_CONTAINING = "Activities.findByDetailContaining";
    public static final String FIND_BY_CREATEDAT = "Activities.findByCreatedAt";
    public static final String FIND_BY_UPDATEDAT = "Activities.findByUpdatedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @activity_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @activity_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-activity_type@
    @Column(name = "activity_type", length = 45, nullable = false, unique = false)
    private String activityType;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @activity_id-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @activity_id-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-activity_id@
    @Column(name = "activity_id", nullable = false, unique = false)
    private Integer activityId;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @title-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @title-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-title@
    @Column(name = "title", length = 45, nullable = false, unique = false)
    private String title;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @detail-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @detail-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-detail@
    @Column(name = "detail", length = 65535, nullable = false, unique = false)
    private String detail;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name = "created_at", nullable = false, unique = false)
    private Timestamp createdAt;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @updated_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @updated_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-updated_at@
    @Column(name = "updated_at", nullable = false, unique = false)
    private Timestamp updatedAt;
//MP-MANAGED-UPDATABLE-ENDING

    /**
     * Default constructor
     */
    public Activities() {
    }

    /**
     * All field constructor
     */
    public Activities(Integer id, String activityType, Integer activityId, String title, String detail, Timestamp createdAt, Timestamp updatedAt) {
        this(id, activityType, activityId, title, detail, createdAt, updatedAt, true);
    }

    public Activities(Integer id, String activityType, Integer activityId, String title, String detail, Timestamp createdAt, Timestamp updatedAt,
            boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setActivityType(activityType);
        setActivityId(activityId);
        setTitle(title);
        setDetail(detail);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        // parents
    }

    public Activities flat() {
        return new Activities(getId(), getActivityType(), getActivityId(), getTitle(), getDetail(), getCreatedAt(), getUpdatedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-activity_type@
    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-activity_id@
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-title@
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-detail@
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-updated_at@
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
