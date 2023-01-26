package com.sdl.eazybank.entity;

import javax.persistence.*;

@Entity
@Table(name = "notice_details")
public class NoticeDetails extends BaseEntity{

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notic_beg_dt")
    private java.sql.Date noticBegDt;

    @Column(name = "notic_end_dt")
    private java.sql.Date noticEndDt;

    @Column(name = "create_dt")
    private java.sql.Date createDt;

    @Column(name = "update_dt")
    private java.sql.Date updateDt;

    public String getNoticeSummary() {
        return this.noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return this.noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public java.sql.Date getNoticBegDt() {
        return this.noticBegDt;
    }

    public void setNoticBegDt(java.sql.Date noticBegDt) {
        this.noticBegDt = noticBegDt;
    }

    public java.sql.Date getNoticEndDt() {
        return this.noticEndDt;
    }

    public void setNoticEndDt(java.sql.Date noticEndDt) {
        this.noticEndDt = noticEndDt;
    }

    public java.sql.Date getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(java.sql.Date createDt) {
        this.createDt = createDt;
    }

    public java.sql.Date getUpdateDt() {
        return this.updateDt;
    }

    public void setUpdateDt(java.sql.Date updateDt) {
        this.updateDt = updateDt;
    }
}
