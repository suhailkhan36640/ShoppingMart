/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.useraddress.entity;

import com.suhail.shopping.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "value")
    private String value;

    @Column(name = "pincode")
    private Integer pinCode;

    // add constructors

    public Area(City city, String value, Integer pinCode) {
        this.city = city;
        this.value = value;
        this.pinCode = pinCode;
    }

    // add getter and setter

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    // override toString method

    @Override
    public String toString() {
        return "Area{" +
                "city=" + city +
                ", value='" + value + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
