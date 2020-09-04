package com.corsface.base.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
/**
 * Created by wbb on 2020/8/13.
 */
@Entity
@Table(name = "be_module")
public class BeModule {
    private Long id;
    private String name;
    private Long parentId;
    private Integer isLeaf;
    private Integer isDisplay;
    private String icon;
    private Integer sortNum;
    private Date gmtCreate;
    private Date gmtModified;

    private String url;
    private long defaultFId = -1;
    private int active = 0;  //用来页面显示,当前模块是否选取状态

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

    @Transient
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Transient
    public long getDefaultFId() {
        return defaultFId;
    }

    public void setDefaultFId(long defaultFId) {
        this.defaultFId = defaultFId;
    }

    @Transient
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
