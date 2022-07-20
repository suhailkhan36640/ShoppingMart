/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.useraddress.entity;

import com.suhail.shopping.common.entity.BaseEntity;
import com.suhail.shopping.user.entity.CommunicationMetaDataType;
import com.suhail.shopping.user.entity.CommunicationType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "address_communication")
public class AddressCommunication extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_address_id")
    private UserAddress userAddress;

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

    public AddressCommunication(UserAddress userAddress, CommunicationType communicationType,
                                CommunicationMetaDataType communicationMetaDataType, String value,
                                boolean varified, Timestamp updatedAt, Timestamp addedAt) {
        this.userAddress = userAddress;
        this.communicationType = communicationType;
        this.communicationMetaDataType = communicationMetaDataType;
        this.value = value;
        this.varified = varified;
        this.updatedAt = updatedAt;
        this.addedAt = addedAt;
    }

    // add getter and setter

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
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

    public boolean isVarified() {
        return varified;
    }

    public void setVarified(boolean varified) {
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
        return "AddressCommunication{" +
                "userAddress=" + userAddress +
                ", communicationType=" + communicationType +
                ", communicationMetaDataType=" + communicationMetaDataType +
                ", value='" + value + '\'' +
                ", varified=" + varified +
                ", updatedAt=" + updatedAt +
                ", addedAt=" + addedAt +
                '}';
    }
}
