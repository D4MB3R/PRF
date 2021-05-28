package com.berec.prf.spring.models;

import java.util.List;

public interface PurchaseService {

    void addPurchase(Purchase purchase);

    List<Purchase> getAllPurchases();

    Purchase getPurchaseById(int id);

    Purchase getPurchaseByName(String name);

    void deletePurchaseById(int id);

}
