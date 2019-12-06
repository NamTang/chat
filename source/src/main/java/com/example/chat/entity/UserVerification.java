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
 * Title: UserVerification
 * </p>
 *
 * <p>
 * Description: Domain Object describing a UserVerification entity
 * </p>
 *
 */
@Entity(name = "UserVerification")
@Table(name = "user_verification")
@NamedQueries({ @NamedQuery(name = UserVerification.FIND_ALL, query = "SELECT a FROM UserVerification a"),
        @NamedQuery(name = UserVerification.FIND_BY_VERIFICATIONCODE, query = "SELECT a FROM UserVerification a WHERE a.verificationCode = :verificationCode"),
        @NamedQuery(name = UserVerification.FIND_BY_VERIFICATIONCODE_CONTAINING, query = "SELECT a FROM UserVerification a WHERE a.verificationCode like :verificationCode"),
        @NamedQuery(name = UserVerification.FIND_BY_CREATEDAT, query = "SELECT a FROM UserVerification a WHERE a.createdAt = :createdAt"),
        @NamedQuery(name = UserVerification.FIND_BY_CREATEDAT_CONTAINING, query = "SELECT a FROM UserVerification a WHERE a.createdAt like :createdAt") })

public class UserVerification implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "UserVerification.findAll";
    public static final String FIND_BY_VERIFICATIONCODE = "UserVerification.findByVerificationCode";
    public static final String FIND_BY_VERIFICATIONCODE_CONTAINING = "UserVerification.findByVerificationCodeContaining";
    public static final String FIND_BY_CREATEDAT = "UserVerification.findByCreatedAt";
    public static final String FIND_BY_CREATEDAT_CONTAINING = "UserVerification.findByCreatedAtContaining";

    @EmbeddedId
    public UserVerificationId userVerificationId__; // MP-MANAGED-ADDED-AREA-BEGINNING @verification_code-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @verification_code-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-verification_code@
    @Column(name = "verification_code", length = 45, nullable = false, unique = false)
    private String verificationCode;
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name = "created_at", length = 45, nullable = false, unique = false)
    private String createdAt;
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId("users_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users usersId;

    @Column(name = "users_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer usersId_;

    /**
     * Default constructor
     */
    public UserVerification() {
    }

    /**
     * All field constructor
     */
    public UserVerification(Integer usersId, String verificationCode, String createdAt) {
        this(usersId, verificationCode, createdAt, true);
    }

    public UserVerification(Integer usersId, String verificationCode, String createdAt, boolean setRelationship) {
        // primary keys
        this.userVerificationId__ = new UserVerificationId();
        // attributes
        setVerificationCode(verificationCode);
        setCreatedAt(createdAt);
        // parents
        if (setRelationship && usersId != null) {
            this.usersId = new Users();
            this.usersId.setId(usersId);
            setUsersId_(usersId);
        }
    }

    public UserVerification flat() {
        return new UserVerification(getUserVerificationId__().getUsersId(), getVerificationCode(), getCreatedAt(), false);
    }

    public UserVerificationId getUserVerificationId__() {
        if (userVerificationId__ == null)
            userVerificationId__ = new UserVerificationId();
        return userVerificationId__;
    }

    public void setUserVerificationId__(UserVerificationId userVerificationId__) {
        this.userVerificationId__ = userVerificationId__;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-verification_code@
    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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
