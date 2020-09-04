package com.product.sc.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by wbb on 2020/8/13.
 */

@Entity
@Table(name = "cf_poi")
public class CfPoi {
    private Long id;
    private String personId;
    private String name;
    private Integer gender;
    private String identityCard;
    private Integer alarmThreshold;
    private Integer flag;
    private String impTag;
    private String imgs;
    private String uploadImgs;
    private String memo;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer residentFlag;

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
    @Column(name = "person_id")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "identity_card")
    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @Basic
    @Column(name = "alarm_threshold")
    public Integer getAlarmThreshold() {
        return alarmThreshold;
    }

    public void setAlarmThreshold(Integer alarmThreshold) {
        this.alarmThreshold = alarmThreshold;
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
    @Column(name = "imp_tag")
    public String getImpTag() {
        return impTag;
    }

    public void setImpTag(String impTag) {
        this.impTag = impTag;
    }

    @Basic
    @Column(name = "imgs")
    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    @Basic
    @Column(name = "upload_imgs")
    public String getUploadImgs() {
        return uploadImgs;
    }

    public void setUploadImgs(String uploadImgs) {
        this.uploadImgs = uploadImgs;
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

    @Basic
    @Column(name = "resident_flag")
    public Integer getResidentFlag() {
        return residentFlag;
    }

    public void setResidentFlag(Integer residentFlag) {
        this.residentFlag = residentFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfPoi cfPoi = (CfPoi) o;
        return Objects.equals(id, cfPoi.id) &&
                Objects.equals(personId, cfPoi.personId) &&
                Objects.equals(name, cfPoi.name) &&
                Objects.equals(gender, cfPoi.gender) &&
                Objects.equals(identityCard, cfPoi.identityCard) &&
                Objects.equals(alarmThreshold, cfPoi.alarmThreshold) &&
                Objects.equals(flag, cfPoi.flag) &&
                Objects.equals(impTag, cfPoi.impTag) &&
                Objects.equals(imgs, cfPoi.imgs) &&
                Objects.equals(uploadImgs, cfPoi.uploadImgs) &&
                Objects.equals(memo, cfPoi.memo) &&
                Objects.equals(gmtCreate, cfPoi.gmtCreate) &&
                Objects.equals(gmtModified, cfPoi.gmtModified) &&
                Objects.equals(residentFlag, cfPoi.residentFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personId, name, gender, identityCard, alarmThreshold, flag, impTag, imgs, uploadImgs, memo, gmtCreate, gmtModified, residentFlag);
    }
}
