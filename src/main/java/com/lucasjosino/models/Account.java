package com.lucasjosino.models;

import com.lucasjosino.enums.BankName;
import com.lucasjosino.enums.BankStatus;

import java.util.List;
import java.util.UUID;

public class Account {
    private String name;
    private UUID uuid;
    private int code;
    private BankName bankName;
    private String accountNumber;
    private List<BankStatus> status;
    private float balance;

    private float transferLimit;

    public Account(
            String name,
            UUID uuid,
            int code,
            BankName bankName,
            String accountNumber,
            List<BankStatus> status,
            float balance,
            float transferLimit
    ) {
        this.name = name;
        this.uuid = uuid;
        this.code = code;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.status = status;
        this.balance = balance;
        this.transferLimit = transferLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BankName getBankName() {
        return bankName;
    }

    public void setBankName(BankName bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<BankStatus> getStatus() {
        return status;
    }

    public void setStatus(List<BankStatus> status) {
        this.status = status;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getTransferLimit() {
        return transferLimit;
    }

    public void setTransferLimit(float transferLimit) {
        this.transferLimit = transferLimit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", code=" + code +
                ", bankName=" + bankName +
                ", accountNumber='" + accountNumber + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }
}
