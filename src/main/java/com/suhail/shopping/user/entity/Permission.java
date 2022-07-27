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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {

    @Column(name = "value")
    private String value;

    // add constructors

    public Permission() {
    }

    public Permission(String value) {
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
        return "Permission{" +
                "value='" + value + '\'' +
                '}';
    }
}
