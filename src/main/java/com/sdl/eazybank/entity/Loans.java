package com.sdl.eazybank.entity;

import javax.persistence.*;

@Entity
@Table(name = "loans")
public class Loans {
    @Id
    @Column(name = "loan_number")
    private Integer loanNumber;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "start_dt")
    private java.sql.Date startDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private Integer totalLoan;

    @Column(name = "amount_paid")
    private Integer amountPaid;

    @Column(name = "outstanding_amount")
    private Integer outstandingAmount;

    @Column(name = "create_dt")
    private java.sql.Date createDt;

    public Integer getLoanNumber() {
        return this.loanNumber;
    }

    public void setLoanNumber(Integer loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public java.sql.Date getStartDt() {
        return this.startDt;
    }

    public void setStartDt(java.sql.Date startDt) {
        this.startDt = startDt;
    }

    public String getLoanType() {
        return this.loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Integer getTotalLoan() {
        return this.totalLoan;
    }

    public void setTotalLoan(Integer totalLoan) {
        this.totalLoan = totalLoan;
    }

    public Integer getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Integer getOutstandingAmount() {
        return this.outstandingAmount;
    }

    public void setOutstandingAmount(Integer outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public java.sql.Date getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(java.sql.Date createDt) {
        this.createDt = createDt;
    }
}
