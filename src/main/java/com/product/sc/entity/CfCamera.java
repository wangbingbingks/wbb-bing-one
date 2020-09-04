package com.product.sc.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by wbb on 2020/8/13.
 */

@Entity
@Table(name = "cf_camera")
public class CfCamera {
    private Long id;
    private String srcId;
    private String name;
    private Long categoryId;
    private Integer flag;
    private String uniCode;
    private String localCode;
    private String installAddress;
    private String coordinate;
    private String ipAddress;
    private Integer modelType;
    private String modelName;
    private String cameraUsername;
    private String cameraPassword;
    private String playUrl;
    private String cjdUrl;
    private String memo;
    private Date gmtCreate;
    private Date gmtModified;
    private String debugUrl;
    private String cjdUuid;
    private Integer cjdSubid;
    private Integer ioFlag;
    private Integer screenNo;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
    @Column(name = "uni_code")
    public String getUniCode() {
        return uniCode;
    }

    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    @Basic
    @Column(name = "local_code")
    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    @Basic
    @Column(name = "install_address")
    public String getInstallAddress() {
        return installAddress;
    }

    public void setInstallAddress(String installAddress) {
        this.installAddress = installAddress;
    }

    @Basic
    @Column(name = "coordinate")
    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Basic
    @Column(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "model_type")
    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    @Basic
    @Column(name = "model_name")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic
    @Column(name = "camera_username")
    public String getCameraUsername() {
        return cameraUsername;
    }

    public void setCameraUsername(String cameraUsername) {
        this.cameraUsername = cameraUsername;
    }

    @Basic
    @Column(name = "camera_password")
    public String getCameraPassword() {
        return cameraPassword;
    }

    public void setCameraPassword(String cameraPassword) {
        this.cameraPassword = cameraPassword;
    }

    @Basic
    @Column(name = "play_url")
    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    @Basic
    @Column(name = "cjd_url")
    public String getCjdUrl() {
        return cjdUrl;
    }

    public void setCjdUrl(String cjdUrl) {
        this.cjdUrl = cjdUrl;
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
    @Column(name = "debug_url")
    public String getDebugUrl() {
        return debugUrl;
    }

    public void setDebugUrl(String debugUrl) {
        this.debugUrl = debugUrl;
    }

    @Basic
    @Column(name = "cjd_uuid")
    public String getCjdUuid() {
        return cjdUuid;
    }

    public void setCjdUuid(String cjdUuid) {
        this.cjdUuid = cjdUuid;
    }

    @Basic
    @Column(name = "cjd_subid")
    public Integer getCjdSubid() {
        return cjdSubid;
    }

    public void setCjdSubid(Integer cjdSubid) {
        this.cjdSubid = cjdSubid;
    }

    @Basic
    @Column(name = "io_flag")
    public Integer getIoFlag() {
        return ioFlag;
    }

    public void setIoFlag(Integer ioFlag) {
        this.ioFlag = ioFlag;
    }

    @Basic
    @Column(name = "screen_no")
    public Integer getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(Integer screenNo) {
        this.screenNo = screenNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CfCamera cfCamera = (CfCamera) o;
        return Objects.equals(id, cfCamera.id) &&
                Objects.equals(srcId, cfCamera.srcId) &&
                Objects.equals(name, cfCamera.name) &&
                Objects.equals(categoryId, cfCamera.categoryId) &&
                Objects.equals(flag, cfCamera.flag) &&
                Objects.equals(uniCode, cfCamera.uniCode) &&
                Objects.equals(localCode, cfCamera.localCode) &&
                Objects.equals(installAddress, cfCamera.installAddress) &&
                Objects.equals(coordinate, cfCamera.coordinate) &&
                Objects.equals(ipAddress, cfCamera.ipAddress) &&
                Objects.equals(modelType, cfCamera.modelType) &&
                Objects.equals(modelName, cfCamera.modelName) &&
                Objects.equals(cameraUsername, cfCamera.cameraUsername) &&
                Objects.equals(cameraPassword, cfCamera.cameraPassword) &&
                Objects.equals(playUrl, cfCamera.playUrl) &&
                Objects.equals(cjdUrl, cfCamera.cjdUrl) &&
                Objects.equals(memo, cfCamera.memo) &&
                Objects.equals(gmtCreate, cfCamera.gmtCreate) &&
                Objects.equals(gmtModified, cfCamera.gmtModified) &&
                Objects.equals(debugUrl, cfCamera.debugUrl) &&
                Objects.equals(cjdUuid, cfCamera.cjdUuid) &&
                Objects.equals(cjdSubid, cfCamera.cjdSubid) &&
                Objects.equals(ioFlag, cfCamera.ioFlag) &&
                Objects.equals(screenNo, cfCamera.screenNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, srcId, name, categoryId, flag, uniCode, localCode, installAddress, coordinate, ipAddress, modelType, modelName, cameraUsername, cameraPassword, playUrl, cjdUrl, memo, gmtCreate, gmtModified, debugUrl, cjdUuid, cjdSubid, ioFlag, screenNo);
    }
}
