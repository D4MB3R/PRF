package com.berec.prf.spring.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	PurchaseRepository purchaseRepo;

	@Autowired
	public PurchaseServiceImpl(PurchaseRepository purchaseRepo) {
		this.purchaseRepo = purchaseRepo;
	}

	@Override
	public void addPurchase(Purchase purchase) {
		purchaseRepo.save(purchase);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		List<Purchase> list = this.purchaseRepo.findAll();
		return list;
	}

	@Override
	public Purchase getPurchaseById(int id) {
		Purchase purchase = this.purchaseRepo.findById(id).get();
		return purchase;
	}

	@Override
	public void deletePurchaseById(int id) {
		this.purchaseRepo.deleteById(id);
	}

	@Override
	public Purchase getPurchaseByName(String name) {
		return this.purchaseRepo.getPurchaseByName(name);
	}

}
