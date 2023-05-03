package com.sdl.eazybank.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class  Accounts extends BaseEntity{
    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_dt")
    private java.sql.Date createDt;

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return this.branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public java.sql.Date getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(java.sql.Date createDt) {
        this.createDt = createDt;
    }
}
