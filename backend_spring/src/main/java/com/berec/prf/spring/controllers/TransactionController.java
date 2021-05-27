package com.berec.prf.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.berec.prf.spring.models.Transaction;
import com.berec.prf.spring.models.TransactionService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class TransactionController {
	
	TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping(path = "/transactions", consumes = "application/json")
	public String newTransaction(@RequestBody Transaction transaction) {
		try {
			this.transactionService.addTransaction(transaction);
			return "Insertion successful!";
		} catch (Exception e) {
			System.out.println(e);
			return "Error, check the server logs!"; 
		}
	}
	
	@GetMapping(path = "/transactions")
	public List<Transaction> getTransactions() {
		try {
			List<Transaction> list= this.transactionService.getAllTransactions();
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@GetMapping("/transaction")
    public Transaction getTransactionById(@RequestParam int id) {
        try {
            return this.transactionService.getTransactionById(id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @DeleteMapping("/transaction")
    public String deleteTransactionById(@RequestParam int id) {
        try {
            this.transactionService.deleteTransactionById(id);
            return "Delete Successful";
        } catch (Exception e) {
            System.out.println(e);
            return "Error during deletion";
        }
    }

}
