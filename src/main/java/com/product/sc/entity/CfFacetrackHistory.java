package com.product.sc.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by wbb on 2020/8/13.
 */

@Entity
@Table(name = "cf_facetrack_history")
public class CfFacetrackHistory {
    private Long id;
    private String facetrackId;
    private String srcId;
    private String transactionId;
    private String judgePerson;
    private Double judgeScore;
    private Double judgeScoreOrig;
    private Double judgePercent;
    private String mostPerson;
    private Double mostScore;
    private Double mostScoreOrig;
    private Double mostPercent;
    private String imgs;
    private String descriptor;
    private Integer judged;
    private Integer alarmed;
    private Integer bindState;
    private Date captureTime;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer flag;
    private Integer glasses;
    private Integer age;
    private Integer moustache;
    private Integer hat;
    private Integer gender;

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
    @Column(name = "facetrack_id")
    public String getFacetrackId() {
        return facetrackId;
    }

    public void setFacetrackId(String facetrackId) {
        this.facetrackId = facetrackId;
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
    @Column(name = "transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "judge_person")
    public String getJudgePerson() {
        return judgePerson;
    }

    public void setJudgePerson(String judgePerson) {
        this.judgePerson = judgePerson;
    }

    @Basic
    @Column(name = "judge_score")
    public Double getJudgeScore() {
        return judgeScore;
    }

    public void setJudgeScore(Double judgeScore) {
        this.judgeScore = judgeScore;
    }

    @Basic
    @Column(name = "judge_score_orig")
    public Double getJudgeScoreOrig() {
        return judgeScoreOrig;
    }

    public void setJudgeScoreOrig(Double judgeScoreOrig) {
        this.judgeScoreOrig = judgeScoreOrig;
    }

    @Basic
    @Column(name = "judge_percent")
    public Double getJudgePercent() {
        return judgePercent;
    }

    public void setJudgePercent(Double judgePercent) {
        this.judgePercent = judgePercent;
    }

    @Basic
    @Column(name = "most_person")
    public String getMostPerson() {
        return mostPerson;
    }

    public void setMostPerson(String mostPerson) {
        this.mostPerson = mostPerson;
    }

    @Basic
    @Column(name = "most_score")
    public Double getMostScore() {
        return mostScore;
    }

    public void setMostScore(Double mostScore) {
        this.mostScore = mostScore;
    }

    @Basic
    @Column(name = "most_score_orig")
    public Double getMostScoreOrig() {
        return mostScoreOrig;
    }

    public void setMostScoreOrig(Double mostScoreOrig) {
        this.mostScoreOrig = mostScoreOrig;
    }

    @Basic
    @Column(name = "most_percent")
    public Double getMostPercent() {
        return mostPercent;
    }

    public void setMostPercent(Double mostPercent) {
        this.mostPercent = mostPercent;
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
    @Column(name = "descriptor")
    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @Basic
    @Column(name = "judged")
    public Integer getJudged() {
        return judged;
    }

    public void setJudged(Integer judged) {
        this.judged = judged;
    }

    @Basic
    @Column(name = "alarmed")
    public Integer getAlarmed() {
        return alarmed;
    }

    public void setAlarmed(Integer alarmed) {
        this.alarmed = alarmed;
    }

    @Basic
    @Column(name = "bind_state")
    public Integer getBindState() {
        return bindState;
    }

    public void setBindState(Integer bindState) {
        this.bindState = bindState;
    }

    @Basic
    @Column(name = "capture_time")
    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
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
    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "glasses")
    public Integer getGlasses() {
        return glasses;
    }

    public void setGlasses(Integer glasses) {
        this.glasses = glasses;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "moustache")
    public Integer getMoustache() {
        return moustache;
    }

    public void setMoustache(Integer moustache) {
        this.moustache = moustache;
    }

    @Basic
    @Column(name = "hat")
    public Integer getHat() {
        return hat;
    }

    public void setHat(Integer hat) {
        this.hat = hat;
    }

    @Basic
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfFacetrackHistory that = (CfFacetrackHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(facetrackId, that.facetrackId) &&
                Objects.equals(srcId, that.srcId) &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(judgePerson, that.judgePerson) &&
                Objects.equals(judgeScore, that.judgeScore) &&
                Objects.equals(judgeScoreOrig, that.judgeScoreOrig) &&
                Objects.equals(judgePercent, that.judgePercent) &&
                Objects.equals(mostPerson, that.mostPerson) &&
                Objects.equals(mostScore, that.mostScore) &&
                Objects.equals(mostScoreOrig, that.mostScoreOrig) &&
                Objects.equals(mostPercent, that.mostPercent) &&
                Objects.equals(imgs, that.imgs) &&
                Objects.equals(descriptor, that.descriptor) &&
                Objects.equals(judged, that.judged) &&
                Objects.equals(alarmed, that.alarmed) &&
                Objects.equals(bindState, that.bindState) &&
                Objects.equals(captureTime, that.captureTime) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(gmtModified, that.gmtModified) &&
                Objects.equals(flag, that.flag) &&
                Objects.equals(glasses, that.glasses) &&
                Objects.equals(age, that.age) &&
                Objects.equals(moustache, that.moustache) &&
                Objects.equals(hat, that.hat) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facetrackId, srcId, transactionId, judgePerson, judgeScore, judgeScoreOrig, judgePercent, mostPerson, mostScore, mostScoreOrig, mostPercent, imgs, descriptor, judged, alarmed, bindState, captureTime, gmtCreate, gmtModified, flag, glasses, age, moustache, hat, gender);
    }
}
