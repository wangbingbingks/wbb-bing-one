package com.corsface.base.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
/**
 * Created by wbb on 2020/8/13.
 */
@Entity
@Table(name = "be_role_function")
public class BeRoleFunction {
    private Long id;
    private Long roleId;
    private Long functionId;
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
    @Column(name = "role_id")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "function_id")
    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
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
        BeRoleFunction that = (BeRoleFunction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(functionId, that.functionId) &&
                Objects.equals(gmtCreate, that.gmtCreate) &&
                Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, functionId, gmtCreate, gmtModified);
    }
}
