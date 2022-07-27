/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

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
@Table(name = "bank_account")
public class BankAccount extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "added_at")
    private Timestamp addedAt;

    @Column(name = "added_by")
    private Integer addedBy;

    // add constructors

    public BankAccount(User user, String userName, String nickName,
                       String bankName, Integer accountNumber, String ifscCode,
                       Timestamp addedAt, Integer addedBy) {
        this.user = user;
        this.userName = userName;
        this.nickName = nickName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.addedAt = addedAt;
        this.addedBy = addedBy;
    }

    // add getter and setter

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }

    // add toString method

    @Override
    public String toString() {
        return "BankAccount{" +
                "user=" + user +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountNumber=" + accountNumber +
                ", ifscCode='" + ifscCode + '\'' +
                ", addedAt=" + addedAt +
                ", addedBy=" + addedBy +
                '}';
    }
}
