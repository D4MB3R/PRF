package com.berec.prf.spring.models;

import java.util.List;

public interface TransactionService {

	void addTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(int id);
    void deleteTransactionById(int id);
	
}
