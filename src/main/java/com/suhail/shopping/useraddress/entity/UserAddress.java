/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.useraddress.entity;

import com.suhail.shopping.common.entity.BaseEntity;
import com.suhail.shopping.user.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_address")
public class UserAddress extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_type_id")
    private AddressType addressType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "locality")
    private String locality;

    @Column(name = "street")
    private String street;

    @Column(name = "landmark")
    private String landMark;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;


    // add constructors

    public UserAddress(User user, Area area, AddressType addressType, String firstName,
                       String middleName, String lastName, String locality,
                       String street, String landMark, String houseNumber,
                       Timestamp createdAt, Timestamp updatedAt) {
        this.user = user;
        this.area = area;
        this.addressType = addressType;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.locality = locality;
        this.street = street;
        this.landMark = landMark;
        this.houseNumber = houseNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // add getter and setter

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    // override toString method

    @Override
    public String toString() {
        return "UserAddress{" +
                "user=" + user +
                ", area=" + area +
                ", addressType=" + addressType +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locality='" + locality + '\'' +
                ", street='" + street + '\'' +
                ", landMark='" + landMark + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
