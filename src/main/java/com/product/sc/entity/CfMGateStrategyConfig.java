package com.product.sc.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cf_m_gate_strategy_config")
public class CfMGateStrategyConfig {
    private Long id;
    private Long gateStrategyId;
    private String appclientSn;
    private Integer timeType;
    private Integer startTime;
    private Integer endTime;
    private String setOpenDate;
    private Date openStartDate;
    private Date openEndDate;
    private Date createDate;
    private Date modifyDate;

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
    @Column(name = "gate_strategy_id")
    public Long getGateStrategyId() {
        return gateStrategyId;
    }

    public void setGateStrategyId(Long gateStrategyId) {
        this.gateStrategyId = gateStrategyId;
    }

    @Basic
    @Column(name = "appclient_sn")
    public String getAppclientSn() {
        return appclientSn;
    }

    public void setAppclientSn(String appclientSn) {
        this.appclientSn = appclientSn;
    }

    @Basic
    @Column(name = "time_type")
    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    @Basic
    @Column(name = "start_time")
    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "set_open_date")
    public String getSetOpenDate() {
        return setOpenDate;
    }

    public void setSetOpenDate(String setOpenDate) {
        this.setOpenDate = setOpenDate;
    }

    @Basic
    @Column(name = "open_start_date")
    public Date getOpenStartDate() {
        return openStartDate;
    }

    public void setOpenStartDate(Date openStartDate) {
        this.openStartDate = openStartDate;
    }

    @Basic
    @Column(name = "open_end_date")
    public Date getOpenEndDate() {
        return openEndDate;
    }

    public void setOpenEndDate(Date openEndDate) {
        this.openEndDate = openEndDate;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_date")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfMGateStrategyConfig that = (CfMGateStrategyConfig) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(gateStrategyId, that.gateStrategyId) &&
                Objects.equals(appclientSn, that.appclientSn) &&
                Objects.equals(timeType, that.timeType) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(setOpenDate, that.setOpenDate) &&
                Objects.equals(openStartDate, that.openStartDate) &&
                Objects.equals(openEndDate, that.openEndDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(modifyDate, that.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gateStrategyId, appclientSn, timeType, startTime, endTime, setOpenDate, openStartDate, openEndDate, createDate, modifyDate);
    }
}
