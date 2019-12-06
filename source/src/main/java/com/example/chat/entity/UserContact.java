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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>
 * Title: UserContact
 * </p>
 *
 * <p>
 * Description: Domain Object describing a UserContact entity
 * </p>
 *
 */
@Entity(name = "UserContact")
@Table(name = "user_contact")
@NamedQueries({ @NamedQuery(name = UserContact.FIND_ALL, query = "SELECT a FROM UserContact a"),
        @NamedQuery(name = UserContact.FIND_BY_FIRSTNAME, query = "SELECT a FROM UserContact a WHERE a.firstName = :firstName"),
        @NamedQuery(name = UserContact.FIND_BY_FIRSTNAME_CONTAINING, query = "SELECT a FROM UserContact a WHERE a.firstName like :firstName"),
        @NamedQuery(name = UserContact.FIND_BY_LASTNAME, query = "SELECT a FROM UserContact a WHERE a.lastName = :lastName"),
        @NamedQuery(name = UserContact.FIND_BY_LASTNAME_CONTAINING, query = "SELECT a FROM UserContact a WHERE a.lastName like :lastName"),
        @NamedQuery(name = UserContact.FIND_BY_CREATEDAT, query = "SELECT a FROM UserContact a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = UserContact.FIND_BY_UPDATEDAT, query = "SELECT a FROM UserContact a WHERE a.updatedAt = :updatedAt") })

public class UserContact implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String __DEFAULT_FIRST_NAME = new String("");
    public static final String __DEFAULT_LAST_NAME = new String("");
    public static final String FIND_ALL = "UserContact.findAll";
    public static final String FIND_BY_FIRSTNAME = "UserContact.findByFirstName";
    public static final String FIND_BY_FIRSTNAME_CONTAINING = "UserContact.findByFirstNameContaining";
    public static final String FIND_BY_LASTNAME = "UserContact.findByLastName";
    public static final String FIND_BY_LASTNAME_CONTAINING = "UserContact.findByLastNameContaining";
    public static final String FIND_BY_CREATEDAT = "UserContact.findByCreatedAt";
    public static final String FIND_BY_UPDATEDAT = "UserContact.findByUpdatedAt";

    @EmbeddedId
    public UserContactId userContactId__; // MP-MANAGED-ADDED-AREA-BEGINNING @first_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @first_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-first_name@
    @Column(name = "first_name", length = 45, nullable = false, unique = false)
    private String firstName;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @last_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @last_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-last_name@
    @Column(name = "last_name", length = 45, nullable = false, unique = false)
    private String lastName;
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

    @MapsId("contact_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Contacts contactId;

    @Column(name = "contact_id", nullable = false, unique = true, insertable = false, updatable = false)
    private Integer contactId_;

    @MapsId("user_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
    private Users userId;

    @Column(name = "user_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer userId_;

    /**
     * Default constructor
     */
    public UserContact() {
    }

    /**
     * All field constructor
     */
    public UserContact(Integer userId, Integer contactId, String firstName, String lastName, Timestamp createdAt, Timestamp updatedAt) {
        this(userId, contactId, firstName, lastName, createdAt, updatedAt, true);
    }

    public UserContact(Integer userId, Integer contactId, String firstName, String lastName, Timestamp createdAt, Timestamp updatedAt,
            boolean setRelationship) {
        // primary keys
        this.userContactId__ = new UserContactId();
        // attributes
        setFirstName(firstName);
        setLastName(lastName);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        // parents
        if (setRelationship && contactId != null) {
            this.contactId = new Contacts();
            this.contactId.setId(contactId);
            setContactId_(contactId);
        }
        if (setRelationship && userId != null) {
            this.userId = new Users();
            this.userId.setId(userId);
            setUserId_(userId);
        }
    }

    public UserContact flat() {
        return new UserContact(getUserContactId__().getUserId(), getUserContactId__().getContactId(), getFirstName(), getLastName(), getCreatedAt(),
                getUpdatedAt(), false);
    }

    public UserContactId getUserContactId__() {
        if (userContactId__ == null)
            userContactId__ = new UserContactId();
        return userContactId__;
    }

    public void setUserContactId__(UserContactId userContactId__) {
        this.userContactId__ = userContactId__;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-first_name@
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-last_name@
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Contacts getContactId() {
        return contactId;
    }

    public void setContactId(Contacts contactId) {
        this.contactId = contactId;
    }

    public Integer getContactId_() {
        return contactId_;
    }

    public void setContactId_(Integer contactId) {
        this.contactId_ = contactId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Integer getUserId_() {
        return userId_;
    }

    public void setUserId_(Integer userId) {
        this.userId_ = userId;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-user_contact@
    @javax.persistence.PrePersist
    public void prePersist_() {
        if (firstName == null)
            firstName = __DEFAULT_FIRST_NAME;
        if (lastName == null)
            lastName = __DEFAULT_LAST_NAME;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-user_contact@
    @javax.persistence.PreUpdate
    public void preUpdate_() {
        if (firstName == null)
            firstName = __DEFAULT_FIRST_NAME;
        if (lastName == null)
            lastName = __DEFAULT_LAST_NAME;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
