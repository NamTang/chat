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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * <p>
 * Title: Users
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Users entity
 * </p>
 *
 */
@Entity(name = "Users")
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = Users.FIND_ALL, query = "SELECT a FROM Users a"),
        @NamedQuery(name = Users.FIND_BY_PHONE, query = "SELECT a FROM Users a WHERE a.phone = :phone"),
        @NamedQuery(name = Users.FIND_BY_PHONE_CONTAINING, query = "SELECT a FROM Users a WHERE a.phone like :phone"),
        @NamedQuery(name = Users.FIND_BY_EMAIL, query = "SELECT a FROM Users a WHERE a.email = :email"),
        @NamedQuery(name = Users.FIND_BY_EMAIL_CONTAINING, query = "SELECT a FROM Users a WHERE a.email like :email"),
        @NamedQuery(name = Users.FIND_BY_PASSWORD, query = "SELECT a FROM Users a WHERE a.password = :password"),
        @NamedQuery(name = Users.FIND_BY_PASSWORD_CONTAINING, query = "SELECT a FROM Users a WHERE a.password like :password"),
        @NamedQuery(name = Users.FIND_BY_FIRSTNAME, query = "SELECT a FROM Users a WHERE a.firstName = :firstName"),
        @NamedQuery(name = Users.FIND_BY_FIRSTNAME_CONTAINING, query = "SELECT a FROM Users a WHERE a.firstName like :firstName"),
        @NamedQuery(name = Users.FIND_BY_LASTNAME, query = "SELECT a FROM Users a WHERE a.lastName = :lastName"),
        @NamedQuery(name = Users.FIND_BY_LASTNAME_CONTAINING, query = "SELECT a FROM Users a WHERE a.lastName like :lastName"),
        @NamedQuery(name = Users.FIND_BY_MIDDLENAME, query = "SELECT a FROM Users a WHERE a.middleName = :middleName"),
        @NamedQuery(name = Users.FIND_BY_MIDDLENAME_CONTAINING, query = "SELECT a FROM Users a WHERE a.middleName like :middleName"),
        @NamedQuery(name = Users.FIND_BY_ISACTIVE, query = "SELECT a FROM Users a WHERE a.isActive = :isActive"),
        @NamedQuery(name = Users.FIND_BY_ISREPORTED, query = "SELECT a FROM Users a WHERE a.isReported = :isReported"),
        @NamedQuery(name = Users.FIND_BY_ISBLOCKED, query = "SELECT a FROM Users a WHERE a.isBlocked = :isBlocked"),
        @NamedQuery(name = Users.FIND_BY_PREFERENCES, query = "SELECT a FROM Users a WHERE a.preferences = :preferences"),
        @NamedQuery(name = Users.FIND_BY_PREFERENCES_CONTAINING, query = "SELECT a FROM Users a WHERE a.preferences like :preferences"),
        @NamedQuery(name = Users.FIND_BY_CREATEDAT, query = "SELECT a FROM Users a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = Users.FIND_BY_UPDATEDAT, query = "SELECT a FROM Users a WHERE a.updatedAt = :updatedAt"),
        @NamedQuery(name = Users.FIND_BY_USER, query = "SELECT a FROM Users a WHERE a.user = :user"),
        @NamedQuery(name = Users.FIND_BY_USER_CONTAINING, query = "SELECT a FROM Users a WHERE a.user like :user"),
        @NamedQuery(name = Users.FIND_BY_CURRENTCONNECTIONS, query = "SELECT a FROM Users a WHERE a.currentConnections = :currentConnections"),
        @NamedQuery(name = Users.FIND_BY_TOTALCONNECTIONS, query = "SELECT a FROM Users a WHERE a.totalConnections = :totalConnections") })

public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String __DEFAULT_FIRST_NAME = new String("");
    public static final String __DEFAULT_LAST_NAME = new String("");
    public static final String __DEFAULT_MIDDLE_NAME = new String("");
    public static final String FIND_ALL = "Users.findAll";
    public static final String FIND_BY_PHONE = "Users.findByPhone";
    public static final String FIND_BY_PHONE_CONTAINING = "Users.findByPhoneContaining";
    public static final String FIND_BY_EMAIL = "Users.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING = "Users.findByEmailContaining";
    public static final String FIND_BY_PASSWORD = "Users.findByPassword";
    public static final String FIND_BY_PASSWORD_CONTAINING = "Users.findByPasswordContaining";
    public static final String FIND_BY_FIRSTNAME = "Users.findByFirstName";
    public static final String FIND_BY_FIRSTNAME_CONTAINING = "Users.findByFirstNameContaining";
    public static final String FIND_BY_LASTNAME = "Users.findByLastName";
    public static final String FIND_BY_LASTNAME_CONTAINING = "Users.findByLastNameContaining";
    public static final String FIND_BY_MIDDLENAME = "Users.findByMiddleName";
    public static final String FIND_BY_MIDDLENAME_CONTAINING = "Users.findByMiddleNameContaining";
    public static final String FIND_BY_ISACTIVE = "Users.findByIsActive";
    public static final String FIND_BY_ISREPORTED = "Users.findByIsReported";
    public static final String FIND_BY_ISBLOCKED = "Users.findByIsBlocked";
    public static final String FIND_BY_PREFERENCES = "Users.findByPreferences";
    public static final String FIND_BY_PREFERENCES_CONTAINING = "Users.findByPreferencesContaining";
    public static final String FIND_BY_CREATEDAT = "Users.findByCreatedAt";
    public static final String FIND_BY_UPDATEDAT = "Users.findByUpdatedAt";
    public static final String FIND_BY_USER = "Users.findByUser";
    public static final String FIND_BY_USER_CONTAINING = "Users.findByUserContaining";
    public static final String FIND_BY_CURRENTCONNECTIONS = "Users.findByCurrentConnections";
    public static final String FIND_BY_TOTALCONNECTIONS = "Users.findByTotalConnections";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @phone-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @phone-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-phone@
    @Column(name = "phone", length = 16, nullable = false, unique = false)
    private String phone;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email@
    @Column(name = "email", length = 255, nullable = false, unique = false)
    private String email;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @password-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @password-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-password@
    @Column(name = "password", length = 40, nullable = false, unique = false)
    private String password;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @first_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @first_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-first_name@
    @Column(name = "first_name", length = 20, nullable = false, unique = false)
    private String firstName;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @last_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @last_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-last_name@
    @Column(name = "last_name", length = 20, nullable = false, unique = false)
    private String lastName;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @middle_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @middle_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-middle_name@
    @Column(name = "middle_name", length = 20, nullable = false, unique = false)
    private String middleName;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_active-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_active-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_active@
    @Column(name = "is_active", nullable = false, unique = false)
    private Boolean isActive;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_reported-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_reported-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_reported@
    @Column(name = "is_reported", nullable = false, unique = false)
    private Boolean isReported;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_blocked-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_blocked-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_blocked@
    @Column(name = "is_blocked", nullable = false, unique = false)
    private Boolean isBlocked;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @preferences-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @preferences-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-preferences@
    @Column(name = "preferences", length = 65535, nullable = false, unique = false)
    private String preferences;
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

//MP-MANAGED-ADDED-AREA-BEGINNING @USER-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @USER-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-USER@
    @Column(name = "USER", length = 32, nullable = true, unique = false)
    private String user;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @CURRENT_CONNECTIONS-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @CURRENT_CONNECTIONS-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-CURRENT_CONNECTIONS@
    @Column(name = "CURRENT_CONNECTIONS", nullable = false, unique = false)
    private Long currentConnections;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @TOTAL_CONNECTIONS-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @TOTAL_CONNECTIONS-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-TOTAL_CONNECTIONS@
    @Column(name = "TOTAL_CONNECTIONS", nullable = false, unique = false)
    private Long totalConnections;
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.Access.class, fetch = FetchType.LAZY, mappedBy = "usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                // cascade=CascadeType.ALL)
    private Set<Access> accessUsersViaUsersId = new HashSet<Access>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @blockListUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.BlockList.class, fetch = FetchType.LAZY, mappedBy = "usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                   // cascade=CascadeType.ALL)
    private Set<BlockList> blockListUsersViaUsersId = new HashSet<BlockList>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @conversationUsersViaCreatorId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.Conversation.class, fetch = FetchType.LAZY, mappedBy = "creatorId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                        // cascade=CascadeType.ALL)
    private Set<Conversation> conversationUsersViaCreatorId = new HashSet<Conversation>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedConversationsUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.DeletedConversations.class, fetch = FetchType.LAZY, mappedBy = "usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                              // cascade=CascadeType.ALL)
    private Set<DeletedConversations> deletedConversationsUsersViaUsersId = new HashSet<DeletedConversations>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedMessagesUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.DeletedMessages.class, fetch = FetchType.LAZY, mappedBy = "usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                         // cascade=CascadeType.ALL)
    private Set<DeletedMessages> deletedMessagesUsersViaUsersId = new HashSet<DeletedMessages>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @devicesUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.Devices.class, fetch = FetchType.LAZY, mappedBy = "usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                 // cascade=CascadeType.ALL)
    private Set<Devices> devicesUsersViaUsersId = new HashSet<Devices>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @messagesUsersViaSenderId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.Messages.class, fetch = FetchType.LAZY, mappedBy = "senderId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                   // cascade=CascadeType.ALL)
    private Set<Messages> messagesUsersViaSenderId = new HashSet<Messages>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @participantsUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.Participants.class, fetch = FetchType.LAZY, mappedBy = "usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                      // cascade=CascadeType.ALL)
    private Set<Participants> participantsUsersViaUsersId = new HashSet<Participants>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reportsUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.Reports.class, fetch = FetchType.LAZY, mappedBy = "usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                 // cascade=CascadeType.ALL)
    private Set<Reports> reportsUsersViaUsersId = new HashSet<Reports>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userContactUsersViaUserId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.UserContact.class, fetch = FetchType.LAZY, mappedBy = "userContactId__.userId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                                    // cascade=CascadeType.ALL)
    private Set<UserContact> userContactUsersViaUserId = new HashSet<UserContact>();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userVerificationUsersViaUsersId-field-users@
    @OneToMany(targetEntity = com.example.chat.entity.UserVerification.class, fetch = FetchType.LAZY, mappedBy = "userVerificationId__.usersId", cascade = CascadeType.REMOVE) // ,
                                                                                                                                                                               // cascade=CascadeType.ALL)
    private Set<UserVerification> userVerificationUsersViaUsersId = new HashSet<UserVerification>();

//MP-MANAGED-UPDATABLE-ENDING
    /**
     * Default constructor
     */
    public Users() {
    }

    /**
     * All field constructor
     */
    public Users(Integer id, String phone, String email, String password, String firstName, String lastName, String middleName, Boolean isActive,
            Boolean isReported, Boolean isBlocked, String preferences, Timestamp createdAt, Timestamp updatedAt, String user, Long currentConnections,
            Long totalConnections) {
        this(id, phone, email, password, firstName, lastName, middleName, isActive, isReported, isBlocked, preferences, createdAt, updatedAt, user,
                currentConnections, totalConnections, true);
    }

    public Users(Integer id, String phone, String email, String password, String firstName, String lastName, String middleName, Boolean isActive,
            Boolean isReported, Boolean isBlocked, String preferences, Timestamp createdAt, Timestamp updatedAt, String user, Long currentConnections,
            Long totalConnections, boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setPhone(phone);
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        setIsActive(isActive);
        setIsReported(isReported);
        setIsBlocked(isBlocked);
        setPreferences(preferences);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setUser(user);
        setCurrentConnections(currentConnections);
        setTotalConnections(totalConnections);
        // parents
    }

    public Users flat() {
        return new Users(getId(), getPhone(), getEmail(), getPassword(), getFirstName(), getLastName(), getMiddleName(), getIsActive(),
                getIsReported(), getIsBlocked(), getPreferences(), getCreatedAt(), getUpdatedAt(), getUser(), getCurrentConnections(),
                getTotalConnections(), false);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    // MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-phone@
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-password@
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//MP-MANAGED-UPDATABLE-ENDING
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-middle_name@
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_active@
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_reported@
    public Boolean getIsReported() {
        return isReported;
    }

    public void setIsReported(Boolean isReported) {
        this.isReported = isReported;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_blocked@
    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-preferences@
    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-USER@
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-CURRENT_CONNECTIONS@
    public Long getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(Long currentConnections) {
        this.currentConnections = currentConnections;
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-TOTAL_CONNECTIONS@
    public Long getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(Long totalConnections) {
        this.totalConnections = totalConnections;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessUsersViaUsersId-getter-users@
    public Set<Access> getAccessUsersViaUsersId() {
        if (accessUsersViaUsersId == null) {
            accessUsersViaUsersId = new HashSet<Access>();
        }
        return accessUsersViaUsersId;
    }

    public void setAccessUsersViaUsersId(Set<Access> accessUsersViaUsersId) {
        this.accessUsersViaUsersId = accessUsersViaUsersId;
    }

    public void addAccessUsersViaUsersId(Access element) {
        getAccessUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @blockListUsersViaUsersId-getter-users@
    public Set<BlockList> getBlockListUsersViaUsersId() {
        if (blockListUsersViaUsersId == null) {
            blockListUsersViaUsersId = new HashSet<BlockList>();
        }
        return blockListUsersViaUsersId;
    }

    public void setBlockListUsersViaUsersId(Set<BlockList> blockListUsersViaUsersId) {
        this.blockListUsersViaUsersId = blockListUsersViaUsersId;
    }

    public void addBlockListUsersViaUsersId(BlockList element) {
        getBlockListUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @conversationUsersViaCreatorId-getter-users@
    public Set<Conversation> getConversationUsersViaCreatorId() {
        if (conversationUsersViaCreatorId == null) {
            conversationUsersViaCreatorId = new HashSet<Conversation>();
        }
        return conversationUsersViaCreatorId;
    }

    public void setConversationUsersViaCreatorId(Set<Conversation> conversationUsersViaCreatorId) {
        this.conversationUsersViaCreatorId = conversationUsersViaCreatorId;
    }

    public void addConversationUsersViaCreatorId(Conversation element) {
        getConversationUsersViaCreatorId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedConversationsUsersViaUsersId-getter-users@
    public Set<DeletedConversations> getDeletedConversationsUsersViaUsersId() {
        if (deletedConversationsUsersViaUsersId == null) {
            deletedConversationsUsersViaUsersId = new HashSet<DeletedConversations>();
        }
        return deletedConversationsUsersViaUsersId;
    }

    public void setDeletedConversationsUsersViaUsersId(Set<DeletedConversations> deletedConversationsUsersViaUsersId) {
        this.deletedConversationsUsersViaUsersId = deletedConversationsUsersViaUsersId;
    }

    public void addDeletedConversationsUsersViaUsersId(DeletedConversations element) {
        getDeletedConversationsUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deletedMessagesUsersViaUsersId-getter-users@
    public Set<DeletedMessages> getDeletedMessagesUsersViaUsersId() {
        if (deletedMessagesUsersViaUsersId == null) {
            deletedMessagesUsersViaUsersId = new HashSet<DeletedMessages>();
        }
        return deletedMessagesUsersViaUsersId;
    }

    public void setDeletedMessagesUsersViaUsersId(Set<DeletedMessages> deletedMessagesUsersViaUsersId) {
        this.deletedMessagesUsersViaUsersId = deletedMessagesUsersViaUsersId;
    }

    public void addDeletedMessagesUsersViaUsersId(DeletedMessages element) {
        getDeletedMessagesUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @devicesUsersViaUsersId-getter-users@
    public Set<Devices> getDevicesUsersViaUsersId() {
        if (devicesUsersViaUsersId == null) {
            devicesUsersViaUsersId = new HashSet<Devices>();
        }
        return devicesUsersViaUsersId;
    }

    public void setDevicesUsersViaUsersId(Set<Devices> devicesUsersViaUsersId) {
        this.devicesUsersViaUsersId = devicesUsersViaUsersId;
    }

    public void addDevicesUsersViaUsersId(Devices element) {
        getDevicesUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @messagesUsersViaSenderId-getter-users@
    public Set<Messages> getMessagesUsersViaSenderId() {
        if (messagesUsersViaSenderId == null) {
            messagesUsersViaSenderId = new HashSet<Messages>();
        }
        return messagesUsersViaSenderId;
    }

    public void setMessagesUsersViaSenderId(Set<Messages> messagesUsersViaSenderId) {
        this.messagesUsersViaSenderId = messagesUsersViaSenderId;
    }

    public void addMessagesUsersViaSenderId(Messages element) {
        getMessagesUsersViaSenderId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @participantsUsersViaUsersId-getter-users@
    public Set<Participants> getParticipantsUsersViaUsersId() {
        if (participantsUsersViaUsersId == null) {
            participantsUsersViaUsersId = new HashSet<Participants>();
        }
        return participantsUsersViaUsersId;
    }

    public void setParticipantsUsersViaUsersId(Set<Participants> participantsUsersViaUsersId) {
        this.participantsUsersViaUsersId = participantsUsersViaUsersId;
    }

    public void addParticipantsUsersViaUsersId(Participants element) {
        getParticipantsUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reportsUsersViaUsersId-getter-users@
    public Set<Reports> getReportsUsersViaUsersId() {
        if (reportsUsersViaUsersId == null) {
            reportsUsersViaUsersId = new HashSet<Reports>();
        }
        return reportsUsersViaUsersId;
    }

    public void setReportsUsersViaUsersId(Set<Reports> reportsUsersViaUsersId) {
        this.reportsUsersViaUsersId = reportsUsersViaUsersId;
    }

    public void addReportsUsersViaUsersId(Reports element) {
        getReportsUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userContactUsersViaUserId-getter-users@
    public Set<UserContact> getUserContactUsersViaUserId() {
        if (userContactUsersViaUserId == null) {
            userContactUsersViaUserId = new HashSet<UserContact>();
        }
        return userContactUsersViaUserId;
    }

    public void setUserContactUsersViaUserId(Set<UserContact> userContactUsersViaUserId) {
        this.userContactUsersViaUserId = userContactUsersViaUserId;
    }

    public void addUserContactUsersViaUserId(UserContact element) {
        getUserContactUsersViaUserId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userVerificationUsersViaUsersId-getter-users@
    public Set<UserVerification> getUserVerificationUsersViaUsersId() {
        if (userVerificationUsersViaUsersId == null) {
            userVerificationUsersViaUsersId = new HashSet<UserVerification>();
        }
        return userVerificationUsersViaUsersId;
    }

    public void setUserVerificationUsersViaUsersId(Set<UserVerification> userVerificationUsersViaUsersId) {
        this.userVerificationUsersViaUsersId = userVerificationUsersViaUsersId;
    }

    public void addUserVerificationUsersViaUsersId(UserVerification element) {
        getUserVerificationUsersViaUsersId().add(element);
    }

//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-users@
    @javax.persistence.PrePersist
    public void prePersist_() {
        if (firstName == null)
            firstName = __DEFAULT_FIRST_NAME;
        if (lastName == null)
            lastName = __DEFAULT_LAST_NAME;
        if (middleName == null)
            middleName = __DEFAULT_MIDDLE_NAME;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-users@
    @javax.persistence.PreUpdate
    public void preUpdate_() {
        if (firstName == null)
            firstName = __DEFAULT_FIRST_NAME;
        if (lastName == null)
            lastName = __DEFAULT_LAST_NAME;
        if (middleName == null)
            middleName = __DEFAULT_MIDDLE_NAME;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
