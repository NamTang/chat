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
 * Title: Messages
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Messages entity
 * </p>
 *
 */
@Entity(name = "Messages")
@Table(name = "messages")
@NamedQueries({ @NamedQuery(name = Messages.FIND_ALL, query = "SELECT a FROM Messages a"),
        @NamedQuery(name = Messages.FIND_BY_GUID, query = "SELECT a FROM Messages a WHERE a.guid = :guid"),
        @NamedQuery(name = Messages.FIND_BY_GUID_CONTAINING, query = "SELECT a FROM Messages a WHERE a.guid like :guid"),
        @NamedQuery(name = Messages.FIND_BY_MESSAGETYPE, query = "SELECT a FROM Messages a WHERE a.messageType = :messageType"),
        @NamedQuery(name = Messages.FIND_BY_MESSAGETYPE_CONTAINING, query = "SELECT a FROM Messages a WHERE a.messageType like :messageType"),
        @NamedQuery(name = Messages.FIND_BY_MESSAGE, query = "SELECT a FROM Messages a WHERE a.message = :message"),
        @NamedQuery(name = Messages.FIND_BY_MESSAGE_CONTAINING, query = "SELECT a FROM Messages a WHERE a.message like :message"),
        @NamedQuery(name = Messages.FIND_BY_ATTACHMENTTHUMBURL, query = "SELECT a FROM Messages a WHERE a.attachmentThumbUrl = :attachmentThumbUrl"),
        @NamedQuery(name = Messages.FIND_BY_ATTACHMENTTHUMBURL_CONTAINING, query = "SELECT a FROM Messages a WHERE a.attachmentThumbUrl like :attachmentThumbUrl"),
        @NamedQuery(name = Messages.FIND_BY_ATTACHMENTURL, query = "SELECT a FROM Messages a WHERE a.attachmentUrl = :attachmentUrl"),
        @NamedQuery(name = Messages.FIND_BY_ATTACHMENTURL_CONTAINING, query = "SELECT a FROM Messages a WHERE a.attachmentUrl like :attachmentUrl"),
        @NamedQuery(name = Messages.FIND_BY_CREATEDAT, query = "SELECT a FROM Messages a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Messages.FIND_BY_DELETEDAT, query = "SELECT a FROM Messages a WHERE a.deletedAt = :deletedAt") })

public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String __DEFAULT_MESSAGE = new String("");
    public static final String __DEFAULT_ATTACHMENT_THUMB_URL = new String("");
    public static final String __DEFAULT_ATTACHMENT_URL = new String("");
    public static final String FIND_ALL = "Messages.findAll";
    public static final String FIND_BY_GUID = "Messages.findByGuid";
    public static final String FIND_BY_GUID_CONTAINING = "Messages.findByGuidContaining";
    public static final String FIND_BY_MESSAGETYPE = "Messages.findByMessageType";
    public static final String FIND_BY_MESSAGETYPE_CONTAINING = "Messages.findByMessageTypeContaining";
    public static final String FIND_BY_MESSAGE = "Messages.findByMessage";
    public static final String FIND_BY_MESSAGE_CONTAINING = "Messages.findByMessageContaining";
    public static final String FIND_BY_ATTACHMENTTHUMBURL = "Messages.findByAttachmentThumbUrl";
    public static final String FIND_BY_ATTACHMENTTHUMBURL_CONTAINING = "Messages.findByAttachmentThumbUrlContaining";
    public static final String FIND_BY_ATTACHMENTURL = "Messages.findByAttachmentUrl";
    public static final String FIND_BY_ATTACHMENTURL_CONTAINING = "Messages.findByAttachmentUrlContaining";
    public static final String FIND_BY_CREATEDAT = "Messages.findByCreatedAt";
    public static final String FIND_BY_DELETEDAT = "Messages.findByDeletedAt";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @guid-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @guid-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-guid@
    @Column(name = "guid", length = 100, nullable = false, unique = false)
    private String guid;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @message_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @message_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-message_type@
    @Column(name = "message_type", length = 5, nullable = false, unique = false)
    private String messageType;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @message-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @message-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-message@
    @Column(name = "message", length = 255, nullable = false, unique = false)
    private String message;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @attachment_thumb_url-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @attachment_thumb_url-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-attachment_thumb_url@
    @Column(name = "attachment_thumb_url", length = 255, nullable = false, unique = false)
    private String attachmentThumbUrl;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @attachment_url-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @attachment_url-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-attachment_url@
    @Column(name = "attachment_url", length = 255, nullable = false, unique = false)
    private String attachmentUrl;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
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
    @JoinColumn(name = "conversation_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Conversation conversationId;

    @Column(name = "conversation_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer conversationId_;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users senderId;

    @Column(name = "sender_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer senderId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedMessagesMessagesViaMessagesId-field-messages@
    @OneToMany(targetEntity = com.example.chat.entity.DeletedMessages.class, fetch = FetchType.LAZY, mappedBy = "messagesId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                            // cascade=CascadeType.ALL)
    private Set<DeletedMessages> deletedMessagesMessagesViaMessagesId = new HashSet<DeletedMessages>();

//MP-MANAGED-UPDATABLE-ENDING
    /**
     * Default constructor
     */
    public Messages() {
    }

    /**
     * All field constructor
     */
    public Messages(Integer id, String guid, Integer conversationId, Integer senderId, String messageType, String message, String attachmentThumbUrl,
            String attachmentUrl, Timestamp createdAt, Timestamp deletedAt) {
        this(id, guid, conversationId, senderId, messageType, message, attachmentThumbUrl, attachmentUrl, createdAt, deletedAt, true);
    }

    public Messages(Integer id, String guid, Integer conversationId, Integer senderId, String messageType, String message, String attachmentThumbUrl,
            String attachmentUrl, Timestamp createdAt, Timestamp deletedAt, boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setGuid(guid);
        setMessageType(messageType);
        setMessage(message);
        setAttachmentThumbUrl(attachmentThumbUrl);
        setAttachmentUrl(attachmentUrl);
        setCreatedAt(createdAt);
        setDeletedAt(deletedAt);
        // parents
        if (setRelationship && conversationId != null) {
            this.conversationId = new Conversation();
            this.conversationId.setId(conversationId);
            setConversationId_(conversationId);
        }
        if (setRelationship && senderId != null) {
            this.senderId = new Users();
            this.senderId.setId(senderId);
            setSenderId_(senderId);
        }
    }

    public Messages flat() {
        return new Messages(getId(), getGuid(), getConversationId_(), getSenderId_(), getMessageType(), getMessage(), getAttachmentThumbUrl(),
                getAttachmentUrl(), getCreatedAt(), getDeletedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-guid@
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-message_type@
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-message@
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-attachment_thumb_url@
    public String getAttachmentThumbUrl() {
        return attachmentThumbUrl;
    }

    public void setAttachmentThumbUrl(String attachmentThumbUrl) {
        this.attachmentThumbUrl = attachmentThumbUrl;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-attachment_url@
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
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

    public Users getSenderId() {
        return senderId;
    }

    public void setSenderId(Users senderId) {
        this.senderId = senderId;
    }

    public Integer getSenderId_() {
        return senderId_;
    }

    public void setSenderId_(Integer senderId) {
        this.senderId_ = senderId;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedMessagesMessagesViaMessagesId-getter-messages@
    public Set<DeletedMessages> getDeletedMessagesMessagesViaMessagesId() {
        if (deletedMessagesMessagesViaMessagesId == null) {
            deletedMessagesMessagesViaMessagesId = new HashSet<DeletedMessages>();
        }
        return deletedMessagesMessagesViaMessagesId;
    }

    public void setDeletedMessagesMessagesViaMessagesId(Set<DeletedMessages> deletedMessagesMessagesViaMessagesId) {
        this.deletedMessagesMessagesViaMessagesId = deletedMessagesMessagesViaMessagesId;
    }

    public void addDeletedMessagesMessagesViaMessagesId(DeletedMessages element) {
        getDeletedMessagesMessagesViaMessagesId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-messages@
    @javax.persistence.PrePersist
    public void prePersist_() {
        if (message == null)
            message = __DEFAULT_MESSAGE;
        if (attachmentThumbUrl == null)
            attachmentThumbUrl = __DEFAULT_ATTACHMENT_THUMB_URL;
        if (attachmentUrl == null)
            attachmentUrl = __DEFAULT_ATTACHMENT_URL;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-messages@
    @javax.persistence.PreUpdate
    public void preUpdate_() {
        if (message == null)
            message = __DEFAULT_MESSAGE;
        if (attachmentThumbUrl == null)
            attachmentThumbUrl = __DEFAULT_ATTACHMENT_THUMB_URL;
        if (attachmentUrl == null)
            attachmentUrl = __DEFAULT_ATTACHMENT_URL;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
