/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.entity;

import com.suhail.shopping.common.entity.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = " user_communication")
public class UserCommunication extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CT_id")
    private CommunicationType communicationType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CMDT_id")
    private CommunicationMetaDataType communicationMetaDataType;

    @Column(name = "value")
    private String value;

    @Column(name = "varified")
    private Boolean varified;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "added_at")
    private Timestamp addedAt;

    // add constructors

    public UserCommunication(User user, CommunicationType communicationType,
                             CommunicationMetaDataType communicationMetaDataType,
                             String value, Boolean varified, Timestamp updatedAt, Timestamp addedAt) {
        this.user = user;
        this.communicationType = communicationType;
        this.communicationMetaDataType = communicationMetaDataType;
        this.value = value;
        this.varified = varified;
        this.updatedAt = updatedAt;
        this.addedAt = addedAt;
    }

    // add getter and setter

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CommunicationType getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(CommunicationType communicationType) {
        this.communicationType = communicationType;
    }

    public CommunicationMetaDataType getCommunicationMetaDataType() {
        return communicationMetaDataType;
    }

    public void setCommunicationMetaDataType(CommunicationMetaDataType communicationMetaDataType) {
        this.communicationMetaDataType = communicationMetaDataType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getVarified() {
        return varified;
    }

    public void setVarified(Boolean varified) {
        this.varified = varified;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    // override toString method

    @Override
    public String toString() {
        return "UserCommunication{" +
                "user=" + user +
                ", communicationType=" + communicationType +
                ", communicationMetaDataType=" + communicationMetaDataType +
                ", value='" + value + '\'' +
                ", varified=" + varified +
                ", updatedAt=" + updatedAt +
                ", addedAt=" + addedAt +
                '}';
    }
}
