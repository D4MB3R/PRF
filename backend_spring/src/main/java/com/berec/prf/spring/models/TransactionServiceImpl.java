package com.berec.prf.spring.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

	TransactionRepository transactionRepo;
	
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepo) {
		this.transactionRepo = transactionRepo;
	}
	
	@Override
	public void addTransaction(Transaction transaction) {
		transactionRepo.save(transaction);	
	}

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> list = this.transactionRepo.findAll();
		return list;
	}

	@Override
	public Transaction getTransactionById(int id) {
		Transaction transaction = this.transactionRepo.findById(id).get();
		return transaction;
	}

	@Override
	public void deleteTransactionById(int id) {
		this.transactionRepo.deleteById(id);		
	}

}
