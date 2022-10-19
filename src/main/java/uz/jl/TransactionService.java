package uz.jl;

import java.math.BigDecimal;

public class TransactionService {
    final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public String transaction(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new RuntimeException("Invalid amount trying to transfer");
        System.out.printf("[SERVICE level log] money with amount '%s' transferred%n", amount);
        return transactionRepository.transfer(amount);
    }
}

class TransactionRepository {

    public String transfer(BigDecimal amount) {
        System.out.printf("[DAO level log] money with amount '%s' transferred%n", amount);
        return "successfully transferred";
    }
}
