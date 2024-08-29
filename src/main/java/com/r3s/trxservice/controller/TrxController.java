package com.r3s.trxservice.controller;

import com.r3s.trxservice.model.request.TrxRq;
import com.r3s.trxservice.model.response.GenericResponse;
import com.r3s.trxservice.service.TransactionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/trx")
@Slf4j
public class TrxController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    ResponseEntity<?> createTrx(@Valid @RequestBody TrxRq trxRq) {
        Object object = transactionService.createTrx(trxRq);
        GenericResponse<?> genericResponse = new GenericResponse<>(HttpStatus.CREATED.value(),"Success",object);
        return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    ResponseEntity<?> getTrx(@Valid @RequestParam UUID trxId) {
        Object object = transactionService.getTrx(trxId);
        GenericResponse<?> genericResponse = new GenericResponse<>(HttpStatus.OK.value(),"Success",object);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }
}
