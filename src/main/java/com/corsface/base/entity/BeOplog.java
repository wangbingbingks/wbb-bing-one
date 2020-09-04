package com.corsface.base.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
/**
 * Created by wbb on 2020/8/13.
 */
@Entity
@Table(name = "be_oplog")
public class BeOplog {
    private Long id;
    private String user;
    private String httpUrl;
    private String httpIp;
    private String httpUa;
    private Integer httpMethod;
    private String httpData;
    private String functionId;
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
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "http_url")
    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    @Basic
    @Column(name = "http_ip")
    public String getHttpIp() {
        return httpIp;
    }

    public void setHttpIp(String httpIp) {
        this.httpIp = httpIp;
    }

    @Basic
    @Column(name = "http_ua")
    public String getHttpUa() {
        return httpUa;
    }

    public void setHttpUa(String httpUa) {
        this.httpUa = httpUa;
    }

    @Basic
    @Column(name = "http_method")
    public Integer getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(Integer httpMethod) {
        this.httpMethod = httpMethod;
    }

    @Basic
    @Column(name = "http_data")
    public String getHttpData() {
        return httpData;
    }

    public void setHttpData(String httpData) {
        this.httpData = httpData;
    }

    @Basic
    @Column(name = "function_id")
    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
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
        BeOplog beOplog = (BeOplog) o;
        return Objects.equals(id, beOplog.id) &&
                Objects.equals(user, beOplog.user) &&
                Objects.equals(httpUrl, beOplog.httpUrl) &&
                Objects.equals(httpIp, beOplog.httpIp) &&
                Objects.equals(httpUa, beOplog.httpUa) &&
                Objects.equals(httpMethod, beOplog.httpMethod) &&
                Objects.equals(httpData, beOplog.httpData) &&
                Objects.equals(functionId, beOplog.functionId) &&
                Objects.equals(gmtCreate, beOplog.gmtCreate) &&
                Objects.equals(gmtModified, beOplog.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, httpUrl, httpIp, httpUa, httpMethod, httpData, functionId, gmtCreate, gmtModified);
    }
}
