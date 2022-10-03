package com.lucasjosino;

import com.lucasjosino.enums.BankStatus;
import com.lucasjosino.exceptions.TransferException;
import com.lucasjosino.models.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Bank {

    private final List<Account> accounts = new ArrayList<>();

    public void createAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public void removeAccount(UUID uuid) {
        accounts.removeIf(account -> account.getUuid() == uuid);
    }

    public Account getAccount(UUID uuid) {
        for (Account account : accounts) {
            if (account.getUuid() == uuid) return account;
        }

        return null;
    }

    public void updateAccountStatus(UUID uuid, List<BankStatus> status) {
        for (Account account : accounts) {
            if (account.getUuid() == uuid) account.setStatus(status);
            return;
        }
    }

    public void transfer(Account from, Account to, float value) throws TransferException {
        if (!accounts.contains(to)) {
            throw new TransferException("Receiver account doesn't exist!");
        }

        if (value <= 0) {
            throw new TransferException("Cannot transfer this value.");
        }

        if (from.getTransferLimit() <= 0) {
            throw new TransferException("Insufficient limit!");
        }

        if (from.getBalance() < value) {
            throw new TransferException("Insufficient balance!");
        }

        from.setBalance(from.getBalance() - value);
        to.setBalance(to.getBalance() + value);

        int fromIndex = accounts.indexOf(from);
        int toIndex = accounts.indexOf(to);

        accounts.set(fromIndex, from);
        accounts.set(toIndex, to);
    }
}
