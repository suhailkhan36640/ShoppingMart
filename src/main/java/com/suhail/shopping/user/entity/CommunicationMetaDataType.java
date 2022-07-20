/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.entity;

import com.suhail.shopping.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_meta_data_type")
public class CommunicationMetaDataType extends BaseEntity {

    @Column(name = "value")
    private String value;

    // add constructors

    public CommunicationMetaDataType(String value) {
        this.value = value;
    }

    // add getter and setter

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // override toString method

    @Override
    public String toString() {
        return "CommunicationMetaDataType{" +
                "value='" + value + '\'' +
                '}';
    }
}
