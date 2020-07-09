package com.corsface.base.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "be_role", schema = "cf", catalog = "")
public class BeRole {
    private Long id;
    private String name;
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
        BeRole beRole = (BeRole) o;
        return Objects.equals(id, beRole.id) &&
                Objects.equals(name, beRole.name) &&
                Objects.equals(gmtCreate, beRole.gmtCreate) &&
                Objects.equals(gmtModified, beRole.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gmtCreate, gmtModified);
    }
}
