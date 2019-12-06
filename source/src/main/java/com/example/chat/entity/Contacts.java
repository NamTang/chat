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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * <p>
 * Title: Contacts
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Contacts entity
 * </p>
 *
 */
@Entity(name = "Contacts")
@Table(name = "contacts")
@NamedQueries({ @NamedQuery(name = Contacts.FIND_ALL, query = "SELECT a FROM Contacts a"),
        @NamedQuery(name = Contacts.FIND_BY_FIRSTNAME, query = "SELECT a FROM Contacts a WHERE a.firstName = :firstName"),
        @NamedQuery(name = Contacts.FIND_BY_FIRSTNAME_CONTAINING, query = "SELECT a FROM Contacts a WHERE a.firstName like :firstName"),
        @NamedQuery(name = Contacts.FIND_BY_MIDDLENAME, query = "SELECT a FROM Contacts a WHERE a.middleName = :middleName"),
        @NamedQuery(name = Contacts.FIND_BY_MIDDLENAME_CONTAINING, query = "SELECT a FROM Contacts a WHERE a.middleName like :middleName"),
        @NamedQuery(name = Contacts.FIND_BY_LASTNAME, query = "SELECT a FROM Contacts a WHERE a.lastName = :lastName"),
        @NamedQuery(name = Contacts.FIND_BY_LASTNAME_CONTAINING, query = "SELECT a FROM Contacts a WHERE a.lastName like :lastName"),
        @NamedQuery(name = Contacts.FIND_BY_PHONE, query = "SELECT a FROM Contacts a WHERE a.phone = :phone"),
        @NamedQuery(name = Contacts.FIND_BY_PHONE_CONTAINING, query = "SELECT a FROM Contacts a WHERE a.phone like :phone"),
        @NamedQuery(name = Contacts.FIND_BY_EMAIL, query = "SELECT a FROM Contacts a WHERE a.email = :email"),
        @NamedQuery(name = Contacts.FIND_BY_EMAIL_CONTAINING, query = "SELECT a FROM Contacts a WHERE a.email like :email"),
        @NamedQuery(name = Contacts.FIND_BY_CREATEDAT, query = "SELECT a FROM Contacts a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Contacts.FIND_BY_CREATEDAT_CONTAINING, query = "SELECT a FROM Contacts a WHERE a.createdAt like :createdAt") })

public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String __DEFAULT_FIRST_NAME = new String("");
    public static final String __DEFAULT_MIDDLE_NAME = new String("");
    public static final String __DEFAULT_LAST_NAME = new String("");
    public static final String FIND_ALL = "Contacts.findAll";
    public static final String FIND_BY_FIRSTNAME = "Contacts.findByFirstName";
    public static final String FIND_BY_FIRSTNAME_CONTAINING = "Contacts.findByFirstNameContaining";
    public static final String FIND_BY_MIDDLENAME = "Contacts.findByMiddleName";
    public static final String FIND_BY_MIDDLENAME_CONTAINING = "Contacts.findByMiddleNameContaining";
    public static final String FIND_BY_LASTNAME = "Contacts.findByLastName";
    public static final String FIND_BY_LASTNAME_CONTAINING = "Contacts.findByLastNameContaining";
    public static final String FIND_BY_PHONE = "Contacts.findByPhone";
    public static final String FIND_BY_PHONE_CONTAINING = "Contacts.findByPhoneContaining";
    public static final String FIND_BY_EMAIL = "Contacts.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING = "Contacts.findByEmailContaining";
    public static final String FIND_BY_CREATEDAT = "Contacts.findByCreatedAt";
    public static final String FIND_BY_CREATEDAT_CONTAINING = "Contacts.findByCreatedAtContaining";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @first_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @first_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-first_name@
    @Column(name = "first_name", length = 20, nullable = false, unique = false)
    private String firstName;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @middle_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @middle_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-middle_name@
    @Column(name = "middle_name", length = 20, nullable = false, unique = false)
    private String middleName;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @last_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @last_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-last_name@
    @Column(name = "last_name", length = 20, nullable = false, unique = false)
    private String lastName;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @phone-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @phone-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-phone@
    @Column(name = "phone", length = 14, nullable = false, unique = false)
    private String phone;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email@
    @Column(name = "email", length = 255, nullable = false, unique = false)
    private String email;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name = "created_at", length = 45, nullable = false, unique = false)
    private String createdAt;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userContactContactsViaContactId-field-contacts@
    @OneToMany(targetEntity = com.example.chat.entity.UserContact.class, fetch = FetchType.LAZY, mappedBy = "userContactId__.contactId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                                       // cascade=CascadeType.ALL)
    private Set<UserContact> userContactContactsViaContactId = new HashSet<UserContact>();

//MP-MANAGED-UPDATABLE-ENDING
    /**
     * Default constructor
     */
    public Contacts() {
    }

    /**
     * All field constructor
     */
    public Contacts(Integer id, String firstName, String middleName, String lastName, String phone, String email, String createdAt) {
        this(id, firstName, middleName, lastName, phone, email, createdAt, true);
    }

    public Contacts(Integer id, String firstName, String middleName, String lastName, String phone, String email, String createdAt,
            boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
        setCreatedAt(createdAt);
        // parents
    }

    public Contacts flat() {
        return new Contacts(getId(), getFirstName(), getMiddleName(), getLastName(), getPhone(), getEmail(), getCreatedAt(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-first_name@
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-middle_name@
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-phone@
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email@
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_at@
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userContactContactsViaContactId-getter-contacts@
    public Set<UserContact> getUserContactContactsViaContactId() {
        if (userContactContactsViaContactId == null) {
            userContactContactsViaContactId = new HashSet<UserContact>();
        }
        return userContactContactsViaContactId;
    }

    public void setUserContactContactsViaContactId(Set<UserContact> userContactContactsViaContactId) {
        this.userContactContactsViaContactId = userContactContactsViaContactId;
    }

    public void addUserContactContactsViaContactId(UserContact element) {
        getUserContactContactsViaContactId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-contacts@
    @javax.persistence.PrePersist
    public void prePersist_() {
        if (firstName == null)
            firstName = __DEFAULT_FIRST_NAME;
        if (middleName == null)
            middleName = __DEFAULT_MIDDLE_NAME;
        if (lastName == null)
            lastName = __DEFAULT_LAST_NAME;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-contacts@
    @javax.persistence.PreUpdate
    public void preUpdate_() {
        if (firstName == null)
            firstName = __DEFAULT_FIRST_NAME;
        if (middleName == null)
            middleName = __DEFAULT_MIDDLE_NAME;
        if (lastName == null)
            lastName = __DEFAULT_LAST_NAME;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
