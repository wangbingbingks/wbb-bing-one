package com.corsface.base.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
/**
 * Created by wbb on 2020/8/13.
 */
@Entity
@Table(name = "be_role")
public class BeRole {
    private Long id;
    private String name;
    private String memo;
    private Integer isinitialization;
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
    @Column(name = "memo")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Basic
    @Column(name = "isinitialization")
    public Integer getIsinitialization() {
        return isinitialization;
    }

    public void setIsinitialization(Integer isinitialization) {
        this.isinitialization = isinitialization;
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
        BeRole beRole = (BeRole) o;
        return Objects.equals(id, beRole.id) &&
                Objects.equals(name, beRole.name) &&
                Objects.equals(memo, beRole.memo) &&
                Objects.equals(isinitialization, beRole.isinitialization) &&
                Objects.equals(gmtCreate, beRole.gmtCreate) &&
                Objects.equals(gmtModified, beRole.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, memo, isinitialization, gmtCreate, gmtModified);
    }
}
