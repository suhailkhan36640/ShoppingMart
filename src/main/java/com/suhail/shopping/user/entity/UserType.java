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
import java.util.List;

@Entity()
@Table(name = "user_type")
public class UserType extends BaseEntity {

    @Column(name = "value")
    private String value;

    // list of permission
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "user_type_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
