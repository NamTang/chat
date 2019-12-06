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
 * Title: DeletedMessages
 * </p>
 *
 * <p>
 * Description: Domain Object describing a DeletedMessages entity
 * </p>
 *
 */
@Entity(name = "DeletedMessages")
@Table(name = "deleted_messages")
@NamedQueries({ @NamedQuery(name = DeletedMessages.FIND_ALL, query = "SELECT a FROM DeletedMessages a"),
        @NamedQuery(name = DeletedMessages.FIND_BY_CREATEDAT, query = "SELECT a FROM DeletedMessages a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = DeletedMessages.FIND_BY_UPDATEDAT, query = "SELECT a FROM DeletedMessages a WHERE a.updatedAt = :updatedAt") })

public class DeletedMessages implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "DeletedMessages.findAll";
    public static final String FIND_BY_CREATEDAT = "DeletedMessages.findByCreatedAt";
    public static final String FIND_BY_UPDATEDAT = "DeletedMessages.findByUpdatedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    @JoinColumn(name = "messages_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Messages messagesId;

    @Column(name = "messages_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer messagesId_;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users usersId;

    @Column(name = "users_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer usersId_;

    /**
     * Default constructor
     */
    public DeletedMessages() {
    }

    /**
     * All field constructor
     */
    public DeletedMessages(Integer id, Integer messagesId, Integer usersId, Timestamp createdAt, Timestamp updatedAt) {
        this(id, messagesId, usersId, createdAt, updatedAt, true);
    }

    public DeletedMessages(Integer id, Integer messagesId, Integer usersId, Timestamp createdAt, Timestamp updatedAt, boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        // parents
        if (setRelationship && messagesId != null) {
            this.messagesId = new Messages();
            this.messagesId.setId(messagesId);
            setMessagesId_(messagesId);
        }
        if (setRelationship && usersId != null) {
            this.usersId = new Users();
            this.usersId.setId(usersId);
            setUsersId_(usersId);
        }
    }

    public DeletedMessages flat() {
        return new DeletedMessages(getId(), getMessagesId_(), getUsersId_(), getCreatedAt(), getUpdatedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Messages getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(Messages messagesId) {
        this.messagesId = messagesId;
    }

    public Integer getMessagesId_() {
        return messagesId_;
    }

    public void setMessagesId_(Integer messagesId) {
        this.messagesId_ = messagesId;
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
