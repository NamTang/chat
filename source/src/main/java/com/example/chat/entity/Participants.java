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
 * Title: Participants
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Participants entity
 * </p>
 *
 */
@Entity(name = "Participants")
@Table(name = "participants")
@NamedQueries({ @NamedQuery(name = Participants.FIND_ALL, query = "SELECT a FROM Participants a"),
        @NamedQuery(name = Participants.FIND_BY_TYPE, query = "SELECT a FROM Participants a WHERE a.type = :type"),
        @NamedQuery(name = Participants.FIND_BY_TYPE_CONTAINING, query = "SELECT a FROM Participants a WHERE a.type like :type"),
        @NamedQuery(name = Participants.FIND_BY_CREATEDAT, query = "SELECT a FROM Participants a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Participants.FIND_BY_UPDATEDAT, query = "SELECT a FROM Participants a WHERE a.updatedAt = :updatedAt") })

public class Participants implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Participants.findAll";
    public static final String FIND_BY_TYPE = "Participants.findByType";
    public static final String FIND_BY_TYPE_CONTAINING = "Participants.findByTypeContaining";
    public static final String FIND_BY_CREATEDAT = "Participants.findByCreatedAt";
    public static final String FIND_BY_UPDATEDAT = "Participants.findByUpdatedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-type@
    @Column(name = "type", length = 6, nullable = false, unique = false)
    private String type;
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
    @JoinColumn(name = "conversation_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Conversation conversationId;

    @Column(name = "conversation_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer conversationId_;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users usersId;

    @Column(name = "users_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer usersId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @blockListParticipantsViaParticipantsId-field-participants@
    @OneToMany(targetEntity = com.example.chat.entity.BlockList.class, fetch = FetchType.LAZY, mappedBy = "participantsId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                          // cascade=CascadeType.ALL)
    private Set<BlockList> blockListParticipantsViaParticipantsId = new HashSet<BlockList>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reportsParticipantsViaParticipantsId-field-participants@
    @OneToMany(targetEntity = com.example.chat.entity.Reports.class, fetch = FetchType.LAZY, mappedBy = "participantsId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                        // cascade=CascadeType.ALL)
    private Set<Reports> reportsParticipantsViaParticipantsId = new HashSet<Reports>();

//MP-MANAGED-UPDATABLE-ENDING
    /**
     * Default constructor
     */
    public Participants() {
    }

    /**
     * All field constructor
     */
    public Participants(Integer id, Integer conversationId, Integer usersId, String type, Timestamp createdAt, Timestamp updatedAt) {
        this(id, conversationId, usersId, type, createdAt, updatedAt, true);
    }

    public Participants(Integer id, Integer conversationId, Integer usersId, String type, Timestamp createdAt, Timestamp updatedAt,
            boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setType(type);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        // parents
        if (setRelationship && conversationId != null) {
            this.conversationId = new Conversation();
            this.conversationId.setId(conversationId);
            setConversationId_(conversationId);
        }
        if (setRelationship && usersId != null) {
            this.usersId = new Users();
            this.usersId.setId(usersId);
            setUsersId_(usersId);
        }
    }

    public Participants flat() {
        return new Participants(getId(), getConversationId_(), getUsersId_(), getType(), getCreatedAt(), getUpdatedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-type@
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Conversation getConversationId() {
        return conversationId;
    }

    public void setConversationId(Conversation conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getConversationId_() {
        return conversationId_;
    }

    public void setConversationId_(Integer conversationId) {
        this.conversationId_ = conversationId;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @blockListParticipantsViaParticipantsId-getter-participants@
    public Set<BlockList> getBlockListParticipantsViaParticipantsId() {
        if (blockListParticipantsViaParticipantsId == null) {
            blockListParticipantsViaParticipantsId = new HashSet<BlockList>();
        }
        return blockListParticipantsViaParticipantsId;
    }

    public void setBlockListParticipantsViaParticipantsId(Set<BlockList> blockListParticipantsViaParticipantsId) {
        this.blockListParticipantsViaParticipantsId = blockListParticipantsViaParticipantsId;
    }

    public void addBlockListParticipantsViaParticipantsId(BlockList element) {
        getBlockListParticipantsViaParticipantsId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reportsParticipantsViaParticipantsId-getter-participants@
    public Set<Reports> getReportsParticipantsViaParticipantsId() {
        if (reportsParticipantsViaParticipantsId == null) {
            reportsParticipantsViaParticipantsId = new HashSet<Reports>();
        }
        return reportsParticipantsViaParticipantsId;
    }

    public void setReportsParticipantsViaParticipantsId(Set<Reports> reportsParticipantsViaParticipantsId) {
        this.reportsParticipantsViaParticipantsId = reportsParticipantsViaParticipantsId;
    }

    public void addReportsParticipantsViaParticipantsId(Reports element) {
        getReportsParticipantsViaParticipantsId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
