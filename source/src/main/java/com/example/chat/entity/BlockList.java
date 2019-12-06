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
 * Title: BlockList
 * </p>
 *
 * <p>
 * Description: Domain Object describing a BlockList entity
 * </p>
 *
 */
@Entity(name = "BlockList")
@Table(name = "block_list")
@NamedQueries({ @NamedQuery(name = BlockList.FIND_ALL, query = "SELECT a FROM BlockList a"),
        @NamedQuery(name = BlockList.FIND_BY_CREATEDAT, query = "SELECT a FROM BlockList a WHERE a.createdAt = :createdAt") })

public class BlockList implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "BlockList.findAll";
    public static final String FIND_BY_CREATEDAT = "BlockList.findByCreatedAt";

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participants_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Participants participantsId;

    @Column(name = "participants_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer participantsId_;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
    private Users usersId;

    @Column(name = "users_id", nullable = false, unique = false, insertable = false, updatable = false)
    private Integer usersId_;

    /**
     * Default constructor
     */
    public BlockList() {
    }

    /**
     * All field constructor
     */
    public BlockList(Integer id, Integer usersId, Integer participantsId, Timestamp createdAt) {
        this(id, usersId, participantsId, createdAt, true);
    }

    public BlockList(Integer id, Integer usersId, Integer participantsId, Timestamp createdAt, boolean setRelationship) {
        // primary keys
        setId(id);
        // attributes
        setCreatedAt(createdAt);
        // parents
        if (setRelationship && participantsId != null) {
            this.participantsId = new Participants();
            this.participantsId.setId(participantsId);
            setParticipantsId_(participantsId);
        }
        if (setRelationship && usersId != null) {
            this.usersId = new Users();
            this.usersId.setId(usersId);
            setUsersId_(usersId);
        }
    }

    public BlockList flat() {
        return new BlockList(getId(), getUsersId_(), getParticipantsId_(), getCreatedAt(), false);
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

    public Participants getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(Participants participantsId) {
        this.participantsId = participantsId;
    }

    public Integer getParticipantsId_() {
        return participantsId_;
    }

    public void setParticipantsId_(Integer participantsId) {
        this.participantsId_ = participantsId;
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
