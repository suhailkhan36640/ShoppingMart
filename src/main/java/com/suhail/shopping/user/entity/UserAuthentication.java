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

@Entity()
@Table(name = "user_authentictaion")
public class UserAuthentication extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "token")
    private String token;

    @Column(name = "expiration_time")
    private Timestamp expirationTime;

    @Column(name = "platform")
    private String platform;

    @Column(name = "platform_OS")
    private String platformOS;

    @Column(name = "platform_OS_version")
    private String platformOSVersion;

    @Column(name = "created_at")
    private Timestamp createdAt;

    // add constructors

    public UserAuthentication(User user, String token, Timestamp expirationTime,
                              String platform, String platformOS, String platformOSVersion,
                              Timestamp createdAt) {
        this.user = user;
        this.token = token;
        this.expirationTime = expirationTime;
        this.platform = platform;
        this.platformOS = platformOS;
        this.platformOSVersion = platformOSVersion;
        this.createdAt = createdAt;
    }

    // add getter and setter

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformOS() {
        return platformOS;
    }

    public void setPlatformOS(String platformOS) {
        this.platformOS = platformOS;
    }

    public String getPlatformOSVersion() {
        return platformOSVersion;
    }

    public void setPlatformOSVersion(String platformOSVersion) {
        this.platformOSVersion = platformOSVersion;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // override toString method

    @Override
    public String toString() {
        return "UserAuthentication{" +
                "user=" + user +
                ", token='" + token + '\'' +
                ", expirationTime=" + expirationTime +
                ", platform='" + platform + '\'' +
                ", platformOS='" + platformOS + '\'' +
                ", platformOSVersion='" + platformOSVersion + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
