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
@Table(name = "city")
public class City extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    @Column(name = "value")
    private String value;

    // add constructors

    public City(Country country, State state, String value) {
        this.country = country;
        this.state = state;
        this.value = value;
    }

    // add getter and setter

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // override toString method

    @Override
    public String toString() {
        return "City{" +
                "country=" + country +
                ", state=" + state +
                ", value='" + value + '\'' +
                '}';
    }
}
