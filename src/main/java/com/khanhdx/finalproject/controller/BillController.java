package com.khanhdx.finalproject.controller;

import com.khanhdx.finalproject.domain.dto.BillDTO;
import com.khanhdx.finalproject.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/bill")
@CrossOrigin("*")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("view-all-bills")
    public ResponseEntity getAllBill (@RequestParam Long billId){
        return (Objects.isNull(billId)) ?
                new ResponseEntity(billService.getAllBills(), HttpStatus.OK) :
                new ResponseEntity(billService.getBillById(billId), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity addNewBill(@RequestBody BillDTO billDTO){
        billService.createNewBill(billDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateBill(@RequestParam Long billId, @RequestBody BillDTO billDTO){
        billService.updateBill(billId, billDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity deleteBill(@RequestParam Long billId){
        billService.deleteBill(billId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
