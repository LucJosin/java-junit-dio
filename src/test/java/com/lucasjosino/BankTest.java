package com.lucasjosino;

import com.lucasjosino.enums.BankName;
import com.lucasjosino.enums.BankStatus;
import com.lucasjosino.exceptions.TransferException;
import com.lucasjosino.models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BankTest {
    private static final Random random = new Random();

    private static final Bank bank = new Bank();

    private static final Account from = new Account(
            "John Doe",
            UUID.randomUUID(),
            random.nextInt(100),
            BankName.BANK_OF_SELENE,
            "305983985718758093",
            List.of(BankStatus.ACTIVE),
            521.8f,
            1000f
    );

    private final Account to = new Account(
            "Maria Doe",
            UUID.randomUUID(),
            random.nextInt(100),
            BankName.BANK_OF_SELENE,
            "317194531987534611",
            List.of(BankStatus.ACTIVE),
            217.1f,
            1000f
    );

    @BeforeAll
    static void addFromAccountToBank() {
        bank.createAccount(from);
    }

    @Test
    void validateThrowOnTransfer() {
        bank.createAccount(to);

        Assertions.assertDoesNotThrow(() -> bank.transfer(from, to, 358.9f));

        Assertions.assertThrows(TransferException.class,
                () -> bank.transfer(from, to, -851.1f)
        );

        bank.removeAccount(from.getUuid());
        bank.removeAccount(to.getUuid());
    }

    @Test
    void doesFromAccountExist() {
        Assertions.assertNotNull(bank.getAccount(from.getUuid()));
    }
}
