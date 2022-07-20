/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.useraddress.entity;

import com.suhail.shopping.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country extends BaseEntity {

      @Column(name = "value")
      private String value;

      // add constructors

    public Country(String value) {
        this.value = value;
    }

    // add getter and setter

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // add toString method

    @Override
    public String toString() {
        return "Country{" +
                "value='" + value + '\'' +
                '}';
    }
}
