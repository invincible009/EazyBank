package com.sdl.eazybank.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_transactions")
public class AccountTransactions extends BaseEntity{

    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "transaction_dt")
    private java.sql.Date transactionDt;

    @Column(name = "transaction_summary")
    private String transactionSummary;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_amt")
    private Integer transactionAmt;

    @Column(name = "closing_balance")
    private Integer closingBalance;

    @Column(name = "create_dt")
    private java.sql.Date createDt;

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public java.sql.Date getTransactionDt() {
        return this.transactionDt;
    }

    public void setTransactionDt(java.sql.Date transactionDt) {
        this.transactionDt = transactionDt;
    }

    public String getTransactionSummary() {
        return this.transactionSummary;
    }

    public void setTransactionSummary(String transactionSummary) {
        this.transactionSummary = transactionSummary;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getTransactionAmt() {
        return this.transactionAmt;
    }

    public void setTransactionAmt(Integer transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public Integer getClosingBalance() {
        return this.closingBalance;
    }

    public void setClosingBalance(Integer closingBalance) {
        this.closingBalance = closingBalance;
    }

    public java.sql.Date getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(java.sql.Date createDt) {
        this.createDt = createDt;
    }
}
