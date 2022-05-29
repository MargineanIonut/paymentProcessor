package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.model.Transaction;
import com.example.demo.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<Iterable<Payment>> getAllTransaction() {
        return new ResponseEntity<>(paymentService.getAllTransactions(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Payment> createTransaction(@RequestBody Payment payment) {
        Payment payment1 = new Payment(payment.getId(), payment.getAmount(), payment.getIsConfirmed());
        paymentService.savePayment(payment);
        return ResponseEntity.created(URI.create("/" + payment.getId())).body(payment);
    }


    @PutMapping
    public ResponseEntity<Payment> updateTransaction(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);
        return ResponseEntity.created(URI.create("/" + payment.getId())).body(payment);
    }

    @DeleteMapping({"/{paymentId}"})
    public ResponseEntity<Boolean> deletePaymentById(@PathVariable("paymentId") Integer id) {
        return new ResponseEntity<>(paymentService.deleteTransaction(id), HttpStatus.OK);
    }
}
