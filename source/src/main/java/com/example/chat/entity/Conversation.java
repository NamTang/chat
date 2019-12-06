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
 * Title: Conversation
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Conversation entity
 * </p>
 *
 */
@Entity(name = "Conversation")
@Table(name = "conversation")
@NamedQueries({ @NamedQuery(name = Conversation.FIND_ALL, query = "SELECT a FROM Conversation a"),
        @NamedQuery(name = Conversation.FIND_BY_TITLE, query = "SELECT a FROM Conversation a WHERE a.title = :title"),
        @NamedQuery(name = Conversation.FIND_BY_TITLE_CONTAINING, query = "SELECT a FROM Conversation a WHERE a.title like :title"),
        @NamedQuery(name = Conversation.FIND_BY_CHANNELID, query = "SELECT a FROM Conversation a WHERE a.channelId = :channelId"),
        @NamedQuery(name = Conversation.FIND_BY_CHANNELID_CONTAINING, query = "SELECT a FROM Conversation a WHERE a.channelId like :channelId"),
        @NamedQuery(name = Conversation.FIND_BY_CREATEDAT, query = "SELECT a FROM Conversation a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Conversation.FIND_BY_UPDATEDAT, query = "SELECT a FROM Conversation a WHERE a.updatedAt = :updatedAt"),
        @NamedQuery(name = Conversation.FIND_BY_DELETEDAT, query = "SELECT a FROM Conversation a WHERE a.deletedAt = :deletedAt") })

public class Conversation implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Conversation.findAll";
    public static final String FIND_BY_TITLE = "Conversation.findByTitle";
    public static final String FIND_BY_TITLE_CONTAINING = "Conversation.findByTitleContaining";
    public static final String FIND_BY_CHANNELID = "Conversation.findByChannelId";
    public static final String FIND_BY_CHANNELID_CONTAINING = "Conversation.findByChannelIdContaining";
    public static final String FIND_BY_CREATEDAT = "Conversation.findByCreatedAt";
    public static final String FIND_BY_UPDATEDAT = "Conversation.findByUpdatedAt";
    public static final String FIND_BY_DELETEDAT = "Conversation.findByDeletedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @title-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @title-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-title@
    @Column(name = "title", length = 40, nullable = false, unique = false)
    private String title;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @channel_id-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @channel_id-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-channel_id@
    @Column(name = "channel_id", length = 45, nullable = false, unique = false)
    private String channelId;
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

//MP-MANAGED-ADDED-AREA-BEGINNING @deleted_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @deleted_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-deleted_at@
    @Column(name = "deleted_at", nullable = false, unique = false)
    private Timestamp deletedAt;
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "creator_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users creatorId;

    @Column(name = "creator_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer creatorId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedConversationsConversationViaConversationId-field-conversation@
    @OneToMany(targetEntity = com.example.chat.entity.DeletedConversations.class, fetch = FetchType.LAZY, mappedBy = "conversationId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                                     // cascade=CascadeType.ALL)
    private Set<DeletedConversations> deletedConversationsConversationViaConversationId = new HashSet<DeletedConversations>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @messagesConversationViaConversationId-field-conversation@
    @OneToMany(targetEntity = com.example.chat.entity.Messages.class, fetch = FetchType.LAZY, mappedBy = "conversationId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                         // cascade=CascadeType.ALL)
    private Set<Messages> messagesConversationViaConversationId = new HashSet<Messages>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @participantsConversationViaConversationId-field-conversation@
    @OneToMany(targetEntity = com.example.chat.entity.Participants.class, fetch = FetchType.LAZY, mappedBy = "conversationId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                             // cascade=CascadeType.ALL)
    private Set<Participants> participantsConversationViaConversationId = new HashSet<Participants>();

//MP-MANAGED-UPDATABLE-ENDING
    /**
     * Default constructor
     */
    public Conversation() {
    }

    /**
     * All field constructor
     */
    public Conversation(Integer id, String title, Integer creatorId, String channelId, Timestamp createdAt, Timestamp updatedAt,
            Timestamp deletedAt) {
        this(id, title, creatorId, channelId, createdAt, updatedAt, deletedAt, true);
    }

    public Conversation(Integer id, String title, Integer creatorId, String channelId, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt,
            boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setTitle(title);
        setChannelId(channelId);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setDeletedAt(deletedAt);
        // parents
        if (setRelationship && creatorId != null) {
            this.creatorId = new Users();
            this.creatorId.setId(creatorId);
            setCreatorId_(creatorId);
        }
    }

    public Conversation flat() {
        return new Conversation(getId(), getTitle(), getCreatorId_(), getChannelId(), getCreatedAt(), getUpdatedAt(), getDeletedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-title@
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-channel_id@
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-deleted_at@
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
//MP-MANAGED-UPDATABLE-ENDING

    public Users getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Users creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getCreatorId_() {
        return creatorId_;
    }

    public void setCreatorId_(Integer creatorId) {
        this.creatorId_ = creatorId;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedConversationsConversationViaConversationId-getter-conversation@
    public Set<DeletedConversations> getDeletedConversationsConversationViaConversationId() {
        if (deletedConversationsConversationViaConversationId == null) {
            deletedConversationsConversationViaConversationId = new HashSet<DeletedConversations>();
        }
        return deletedConversationsConversationViaConversationId;
    }

    public void setDeletedConversationsConversationViaConversationId(Set<DeletedConversations> deletedConversationsConversationViaConversationId) {
        this.deletedConversationsConversationViaConversationId = deletedConversationsConversationViaConversationId;
    }

    public void addDeletedConversationsConversationViaConversationId(DeletedConversations element) {
        getDeletedConversationsConversationViaConversationId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @messagesConversationViaConversationId-getter-conversation@
    public Set<Messages> getMessagesConversationViaConversationId() {
        if (messagesConversationViaConversationId == null) {
            messagesConversationViaConversationId = new HashSet<Messages>();
        }
        return messagesConversationViaConversationId;
    }

    public void setMessagesConversationViaConversationId(Set<Messages> messagesConversationViaConversationId) {
        this.messagesConversationViaConversationId = messagesConversationViaConversationId;
    }

    public void addMessagesConversationViaConversationId(Messages element) {
        getMessagesConversationViaConversationId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @participantsConversationViaConversationId-getter-conversation@
    public Set<Participants> getParticipantsConversationViaConversationId() {
        if (participantsConversationViaConversationId == null) {
            participantsConversationViaConversationId = new HashSet<Participants>();
        }
        return participantsConversationViaConversationId;
    }

    public void setParticipantsConversationViaConversationId(Set<Participants> participantsConversationViaConversationId) {
        this.participantsConversationViaConversationId = participantsConversationViaConversationId;
    }

    public void addParticipantsConversationViaConversationId(Participants element) {
        getParticipantsConversationViaConversationId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
