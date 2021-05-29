package com.berec.prf.spring.controllers;

import java.sql.Date;
import java.time.LocalDate;
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

import com.berec.prf.spring.models.Purchase;
import com.berec.prf.spring.models.PurchaseService;
import com.berec.prf.spring.models.Transaction;
import com.berec.prf.spring.models.TransactionService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class PurchaseController {

	PurchaseService purchaseService;
	TransactionService transactionService;

	@Autowired
	public PurchaseController(PurchaseService purchaseService, TransactionService transactionService) {
		this.purchaseService = purchaseService;
		this.transactionService = transactionService;
	}

	@PostMapping(path = "/purchases", consumes = "application/json")
	public String newPurchase(@RequestBody Purchase purchase) {
		try {
			int purchase_id;
			Purchase purchaseInDatabase = this.purchaseService.getPurchaseByName(purchase.getName());
			if (purchaseInDatabase == null) {
				this.purchaseService.addPurchase(purchase);
				purchase_id = purchase.getPurchase_id();
			} else {
				purchase_id = purchaseInDatabase.getPurchase_id();
			}
			Date date_of_purchase = new Date(System.currentTimeMillis());
			Transaction transaction = new Transaction();
			transaction.setDate_of_purchase(date_of_purchase);
			transaction.setPurchase_id(purchase_id);
			transaction.setPrice(purchase.getPrice());
			this.transactionService.addTransaction(transaction);
			return "Insertion successful!";
		} catch (Exception e) {
			System.out.println(e);
			return "Error, check the server logs!";
		}
	}

	@GetMapping(path = "/purchases")
	public List<Purchase> getPurchases() {
		try {
			List<Purchase> list = this.purchaseService.getAllPurchases();
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/purchase")
	public Purchase getPurchaseById(@RequestParam int id) {
		try {
			return this.purchaseService.getPurchaseById(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@DeleteMapping("/purchase")
	public String deletePurchaseById(@RequestParam int id) {
		try {
			this.purchaseService.deletePurchaseById(id);
			return "Delete Successful";
		} catch (Exception e) {
			System.out.println(e);
			return "Error during deletion";
		}
	}

}
