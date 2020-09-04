package com.product.sc.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by wbb on 2020/8/13.
 */

@Entity
@Table(name = "cf_alarm_history")
public class CfAlarmHistory {
    private Long id;
    private String srcId;
    private String facetrackId;
    private String personId;
    private Long alarmConfigId;
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
    @Column(name = "src_id")
    public String getSrcId() {
        return srcId;
    }

    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }

    @Basic
    @Column(name = "facetrack_id")
    public String getFacetrackId() {
        return facetrackId;
    }

    public void setFacetrackId(String facetrackId) {
        this.facetrackId = facetrackId;
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
    @Column(name = "alarm_config_id")
    public Long getAlarmConfigId() {
        return alarmConfigId;
    }

    public void setAlarmConfigId(Long alarmConfigId) {
        this.alarmConfigId = alarmConfigId;
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
        CfAlarmHistory that = (CfAlarmHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(srcId, that.srcId) &&
                Objects.equals(facetrackId, that.facetrackId) &&
                Objects.equals(personId, that.personId) &&
                Objects.equals(alarmConfigId, that.alarmConfigId) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, srcId, facetrackId, personId, alarmConfigId, gmtCreate, gmtModified);
    }
}
