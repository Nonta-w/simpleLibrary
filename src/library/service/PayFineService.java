// src/library/service/PayFineService.java
package library.service;

import library.dao.FineDAO;
import library.model.Fine;
import library.util.Logger;

public class PayFineService {
    private final FineDAO dao;

    public PayFineService(FineDAO dao) {
        this.dao = dao;
    }

    public void pay(String fineId, double amount) {
        Fine fine = dao.find(fineId);
        if (fine == null)
            throw new IllegalArgumentException("Fine not found");
        if (fine.isPaid())
            throw new IllegalStateException("Fine already paid");

        if (amount < fine.getAmount())
            throw new IllegalArgumentException("Insufficient amount");

        fine.setPaid(true);
        Logger.info("Fine " + fineId + " paid: " + amount + " THB");
    }
}