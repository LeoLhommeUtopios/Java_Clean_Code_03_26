package org.example.srp;

import java.util.List;

public class AccountService {

    private TransactionRepository transactionRepository;
    private Clock clock;
    private Console console;

    private final PrintStatementService printStatementService;

    public AccountService(TransactionRepository transactionRepository, Clock clock, Console console,PrintStatementService printStatementService) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.console = console;
        this.printStatementService = printStatementService;
    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }


    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    public void printStatement(){
        List<Transaction> transactions = transactionRepository.all();
        printStatementService.printStatement(transactions);
    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }



}
