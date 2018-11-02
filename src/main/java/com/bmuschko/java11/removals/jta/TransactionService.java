package com.bmuschko.java11.removals.jta;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public class TransactionService {
    @Transactional
    public void transferMoney(String sourceAccountId, String targetAccountId, BigDecimal amount) {
        // transfer money
    }
}
