package com.corsface.base.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "be_module", schema = "cf", catalog = "")
public class BeModule {
    private Long id;
    private String name;
    private Long parentId;
    private Integer isLeaf;
    private Integer isDisplay;
    private String icon;
    private Integer sortNum;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    @Id
    @Column(name = "id")
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
    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "is_leaf")
    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    @Basic
    @Column(name = "is_display")
    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "sort_num")
    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    @Basic
    @Column(name = "gmt_create")
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified")
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeModule beModule = (BeModule) o;
        return Objects.equals(id, beModule.id) &&
                Objects.equals(name, beModule.name) &&
                Objects.equals(parentId, beModule.parentId) &&
                Objects.equals(isLeaf, beModule.isLeaf) &&
                Objects.equals(isDisplay, beModule.isDisplay) &&
                Objects.equals(icon, beModule.icon) &&
                Objects.equals(sortNum, beModule.sortNum) &&
                Objects.equals(gmtCreate, beModule.gmtCreate) &&
                Objects.equals(gmtModified, beModule.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parentId, isLeaf, isDisplay, icon, sortNum, gmtCreate, gmtModified);
    }
}
