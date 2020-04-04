package com.khanhdx.finalproject.service;

import com.khanhdx.finalproject.domain.dto.BillDTO;
import com.khanhdx.finalproject.domain.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAllBills();
    Bill getBillById(Long billId);
    void createNewBill(BillDTO billDTO);
    void updateBill(Long billId, BillDTO billDTO);
    void deleteBill(Long billId);


}
