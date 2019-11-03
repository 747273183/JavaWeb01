package com.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer eid;
    private String ename;
    private String esex;
    private Integer eage;
    private String ehobby;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer eid, String ename, String esex, Integer eage, String ehobby, Dept dept) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.eage = eage;
        this.ehobby = ehobby;
        this.dept = dept;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEhobby() {
        return ehobby;
    }

    public void setEhobby(String ehobby) {
        this.ehobby = ehobby;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", eage=" + eage +
                ", ehobby='" + ehobby + '\'' +
                ", dept=" + dept +
                '}';
    }
}
