package com.product.sc.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cf_dictory", schema = "cf", catalog = "")
public class CfDictory {
    private Long id;
    private String dicKey;
    private String dicValue;
    private String dicName;
    private String dicTag;
    private Integer sortNo;
    private Integer flag;
    private String memo;
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
    @Column(name = "dic_key")
    public String getDicKey() {
        return dicKey;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey;
    }

    @Basic
    @Column(name = "dic_value")
    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    @Basic
    @Column(name = "dic_name")
    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    @Basic
    @Column(name = "dic_tag")
    public String getDicTag() {
        return dicTag;
    }

    public void setDicTag(String dicTag) {
        this.dicTag = dicTag;
    }

    @Basic
    @Column(name = "sort_no")
    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    @Basic
    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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
        CfDictory cfDictory = (CfDictory) o;
        return Objects.equals(id, cfDictory.id) &&
                Objects.equals(dicKey, cfDictory.dicKey) &&
                Objects.equals(dicValue, cfDictory.dicValue) &&
                Objects.equals(dicName, cfDictory.dicName) &&
                Objects.equals(dicTag, cfDictory.dicTag) &&
                Objects.equals(sortNo, cfDictory.sortNo) &&
                Objects.equals(flag, cfDictory.flag) &&
                Objects.equals(memo, cfDictory.memo) &&
                Objects.equals(gmtCreate, cfDictory.gmtCreate) &&
                Objects.equals(gmtModified, cfDictory.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dicKey, dicValue, dicName, dicTag, sortNo, flag, memo, gmtCreate, gmtModified);
    }
}
