package com.corsface.base.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
/**
 * Created by wbb on 2020/8/13.
 */
@Entity
@Table(name = "be_user")
public class BeUser {
    private Long id;
    private String name;
    private String loginName;
    private String password;
    private String salt;
    private Integer serviceFlag;
    private Date lastLogin;
    private String token;
    private Date tokenExpire;
    private Date gmtCreate;
    private Date gmtModified;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "login_name")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "service_flag")
    public Integer getServiceFlag() {
        return serviceFlag;
    }

    public void setServiceFlag(Integer serviceFlag) {
        this.serviceFlag = serviceFlag;
    }

    @Basic
    @Column(name = "last_login")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "token_expire")
    public Date getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Date tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    @Basic
    @Column(name = "gmt_create")
    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified")
    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeUser beUser = (BeUser) o;
        return Objects.equals(id, beUser.id) &&
                Objects.equals(name, beUser.name) &&
                Objects.equals(loginName, beUser.loginName) &&
                Objects.equals(password, beUser.password) &&
                Objects.equals(salt, beUser.salt) &&
                Objects.equals(serviceFlag, beUser.serviceFlag) &&
                Objects.equals(lastLogin, beUser.lastLogin) &&
                Objects.equals(token, beUser.token) &&
                Objects.equals(tokenExpire, beUser.tokenExpire) &&
                Objects.equals(gmtCreate, beUser.gmtCreate) &&
                Objects.equals(gmtModified, beUser.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, loginName, password, salt, serviceFlag, lastLogin, token, tokenExpire, gmtCreate, gmtModified);
    }
}
