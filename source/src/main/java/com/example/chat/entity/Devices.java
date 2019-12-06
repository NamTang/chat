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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * <p>
 * Title: Devices
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Devices entity
 * </p>
 *
 */
@Entity(name = "Devices")
@Table(name = "devices")
@NamedQueries({ @NamedQuery(name = Devices.FIND_ALL, query = "SELECT a FROM Devices a"),
        @NamedQuery(name = Devices.FIND_BY_DEVICEID, query = "SELECT a FROM Devices a WHERE a.deviceId = :deviceId"),
        @NamedQuery(name = Devices.FIND_BY_DEVICEID_CONTAINING, query = "SELECT a FROM Devices a WHERE a.deviceId like :deviceId"),
        @NamedQuery(name = Devices.FIND_BY_TYPE, query = "SELECT a FROM Devices a WHERE a.type = :type"),
        @NamedQuery(name = Devices.FIND_BY_TYPE_CONTAINING, query = "SELECT a FROM Devices a WHERE a.type like :type"),
        @NamedQuery(name = Devices.FIND_BY_DEVICETOKEN, query = "SELECT a FROM Devices a WHERE a.deviceToken = :deviceToken"),
        @NamedQuery(name = Devices.FIND_BY_DEVICETOKEN_CONTAINING, query = "SELECT a FROM Devices a WHERE a.deviceToken like :deviceToken"),
        @NamedQuery(name = Devices.FIND_BY_CREATEDAT, query = "SELECT a FROM Devices a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Devices.FIND_BY_UPDATEDAT, query = "SELECT a FROM Devices a WHERE a.updatedAt = :updatedAt") })

public class Devices implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Devices.findAll";
    public static final String FIND_BY_DEVICEID = "Devices.findByDeviceId";
    public static final String FIND_BY_DEVICEID_CONTAINING = "Devices.findByDeviceIdContaining";
    public static final String FIND_BY_TYPE = "Devices.findByType";
    public static final String FIND_BY_TYPE_CONTAINING = "Devices.findByTypeContaining";
    public static final String FIND_BY_DEVICETOKEN = "Devices.findByDeviceToken";
    public static final String FIND_BY_DEVICETOKEN_CONTAINING = "Devices.findByDeviceTokenContaining";
    public static final String FIND_BY_CREATEDAT = "Devices.findByCreatedAt";
    public static final String FIND_BY_UPDATEDAT = "Devices.findByUpdatedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @device_id-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @device_id-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-device_id@
    @Column(name = "device_id", length = 120, nullable = false, unique = false)
    private String deviceId;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-type@
    @Column(name = "type", length = 5, nullable = false, unique = false)
    private String type;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @device_token-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @device_token-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-device_token@
    @Column(name = "device_token", length = 120, nullable = false, unique = false)
    private String deviceToken;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users usersId;

    @Column(name = "users_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer usersId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessDevicesViaDevicesId-field-devices@
    @OneToMany(targetEntity = com.example.chat.entity.Access.class, fetch = FetchType.LAZY, mappedBy = "devicesId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                                // cascade=CascadeType.ALL)
    private Set<Access> accessDevicesViaDevicesId = new HashSet<Access>();

//MP-MANAGED-UPDATABLE-ENDING
    /**
     * Default constructor
     */
    public Devices() {
    }

    /**
     * All field constructor
     */
    public Devices(Integer id, Integer usersId, String deviceId, String type, String deviceToken, Timestamp createdAt, Timestamp updatedAt) {
        this(id, usersId, deviceId, type, deviceToken, createdAt, updatedAt, true);
    }

    public Devices(Integer id, Integer usersId, String deviceId, String type, String deviceToken, Timestamp createdAt, Timestamp updatedAt,
            boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setDeviceId(deviceId);
        setType(type);
        setDeviceToken(deviceToken);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        // parents
        if (setRelationship && usersId != null) {
            this.usersId = new Users();
            this.usersId.setId(usersId);
            setUsersId_(usersId);
        }
    }

    public Devices flat() {
        return new Devices(getId(), getUsersId_(), getDeviceId(), getType(), getDeviceToken(), getCreatedAt(), getUpdatedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-device_id@
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-type@
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-device_token@
    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessDevicesViaDevicesId-getter-devices@
    public Set<Access> getAccessDevicesViaDevicesId() {
        if (accessDevicesViaDevicesId == null) {
            accessDevicesViaDevicesId = new HashSet<Access>();
        }
        return accessDevicesViaDevicesId;
    }

    public void setAccessDevicesViaDevicesId(Set<Access> accessDevicesViaDevicesId) {
        this.accessDevicesViaDevicesId = accessDevicesViaDevicesId;
    }

    public void addAccessDevicesViaDevicesId(Access element) {
        getAccessDevicesViaDevicesId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
