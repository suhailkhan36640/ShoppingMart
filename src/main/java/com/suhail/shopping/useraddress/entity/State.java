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
@Table(name = "state")
public class State extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    // add constructors
    public State(Country country) {
        this.country = country;
    }

    // add getter and setter

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    // override toString method

    @Override
    public String toString() {
        return "State{" +
                "country=" + country +
                '}';
    }
}
