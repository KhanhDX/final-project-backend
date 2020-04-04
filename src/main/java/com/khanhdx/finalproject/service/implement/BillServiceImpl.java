package com.khanhdx.finalproject.service.implement;

import com.khanhdx.finalproject.domain.dto.BillDTO;
import com.khanhdx.finalproject.domain.model.Bill;
import com.khanhdx.finalproject.repository.BillRepo;
import com.khanhdx.finalproject.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepo billRepo;

    @Override
    public List<Bill> getAllBills() {
        return billRepo.findAll();
    }

    @Override
    public Bill getBillById(Long billId) {
        return billRepo.findBillByBillId(billId);
    }

    @Override
    public void createNewBill(BillDTO billDTO) {
        Bill bill = new Bill();
        bill.setAmount(billDTO.getAmount());
        bill.setCourseId(billDTO.getCourseId());
        bill.setStudentId(billDTO.getStudentId());
        bill.setStatus(billDTO.getStatus());
        billRepo.save(bill);
    }

    @Override
    public void updateBill(Long billId, BillDTO billDTO) {
        Bill bill = billRepo.findBillByBillId(billId);
        bill.setAmount(billDTO.getAmount());
        bill.setCourseId(billDTO.getCourseId());
        bill.setStudentId(billDTO.getStudentId());
        bill.setStatus(billDTO.getStatus());
        billRepo.save(bill);
    }

    @Override
    public void deleteBill(Long billId) {
        billRepo.delete(billRepo.findBillByBillId(billId));
    }
}
