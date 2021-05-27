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

import com.berec.prf.spring.models.Purchase;
import com.berec.prf.spring.models.PurchaseService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class PurchaseController {

	PurchaseService purchaseService;
	
	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@PostMapping(path = "/purchases", consumes = "application/json")
	public String newPurchase(@RequestBody Purchase purchase) {
		try {
			this.purchaseService.addPurchase(purchase);
			return "Insertion successful!";
		} catch (Exception e) {
			System.out.println(e);
			return "Error, check the server logs!"; 
		}
	}
	
	@GetMapping(path = "/purchases")
	public List<Purchase> getPurchases() {
		try {
			List<Purchase> list= this.purchaseService.getAllPurchases();
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
    public String deleteToDoById(@RequestParam int id) {
        try {
            this.purchaseService.deletePurchaseById(id);
            return "Delete Successful";
        } catch (Exception e) {
            System.out.println(e);
            return "Error during deletion";
        }
    }
	
}
