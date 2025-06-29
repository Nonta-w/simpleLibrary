// src/library/controller/FineController.java
package library.controller;

import library.dao.FineDAO;
import library.model.Fine;
import library.service.PayFineService;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Exposes fine-related operations to the UI.
 */
public class FineController {

    private final PayFineService paySvc;
    private final FineDAO fineDAO;

    public FineController(FineDAO fineDAO) {
        this.fineDAO = fineDAO;
        this.paySvc = new PayFineService(fineDAO);
    }

    /** Pay a specific fine in full. */
    public void payFine(String fineId, double amount) {
        paySvc.pay(fineId, amount);
    }

    /** Retrieve all unpaid fines (system-wide or filter in UI as needed). */
    public Collection<Fine> listUnpaidFines() {
        return fineDAO.unpaid().collect(Collectors.toList());
    }
}