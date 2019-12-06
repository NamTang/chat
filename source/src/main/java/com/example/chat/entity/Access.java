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
 * Title: Access
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Access entity
 * </p>
 *
 */
@Entity(name = "Access")
@Table(name = "access")
@NamedQueries({ @NamedQuery(name = Access.FIND_ALL, query = "SELECT a FROM Access a"),
        @NamedQuery(name = Access.FIND_BY_TOKEN, query = "SELECT a FROM Access a WHERE a.token = :token"),
        @NamedQuery(name = Access.FIND_BY_TOKEN_CONTAINING, query = "SELECT a FROM Access a WHERE a.token like :token"),
        @NamedQuery(name = Access.FIND_BY_CREATEDAT, query = "SELECT a FROM Access a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Access.FIND_BY_DELETEDAT, query = "SELECT a FROM Access a WHERE a.deletedAt = :deletedAt") })

public class Access implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Access.findAll";
    public static final String FIND_BY_TOKEN = "Access.findByToken";
    public static final String FIND_BY_TOKEN_CONTAINING = "Access.findByTokenContaining";
    public static final String FIND_BY_CREATEDAT = "Access.findByCreatedAt";
    public static final String FIND_BY_DELETEDAT = "Access.findByDeletedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token", length = 60, nullable = false, unique = false)
    private String token;

    @Column(name = "created_at", nullable = false, unique = false)
    private Timestamp createdAt;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @deleted_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @deleted_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-deleted_at@
    @Column(name = "deleted_at", nullable = false, unique = false)
    private Timestamp deletedAt;
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "devices_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Devices devicesId;

    @Column(name = "devices_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer devicesId_;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users usersId;

    @Column(name = "users_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer usersId_;

    /**
     * Default constructor
     */
    public Access() {
    }

    /**
     * All field constructor
     */
    public Access(Integer id, Integer usersId, Integer devicesId, String token, Timestamp createdAt, Timestamp deletedAt) {
        this(id, usersId, devicesId, token, createdAt, deletedAt, true);
    }

    public Access(Integer id, Integer usersId, Integer devicesId, String token, Timestamp createdAt, Timestamp deletedAt, boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setToken(token);
        setCreatedAt(createdAt);
        setDeletedAt(deletedAt);
        // parents
        if (setRelationship && devicesId != null) {
            this.devicesId = new Devices();
            this.devicesId.setId(devicesId);
            setDevicesId_(devicesId);
        }
        if (setRelationship && usersId != null) {
            this.usersId = new Users();
            this.usersId.setId(usersId);
            setUsersId_(usersId);
        }
    }

    public Access flat() {
        return new Access(getId(), getUsersId_(), getDevicesId_(), getToken(), getCreatedAt(), getDeletedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-token@
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-deleted_at@
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
//MP-MANAGED-UPDATABLE-ENDING

    public Devices getDevicesId() {
        return devicesId;
    }

    public void setDevicesId(Devices devicesId) {
        this.devicesId = devicesId;
    }

    public Integer getDevicesId_() {
        return devicesId_;
    }

    public void setDevicesId_(Integer devicesId) {
        this.devicesId_ = devicesId;
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

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
