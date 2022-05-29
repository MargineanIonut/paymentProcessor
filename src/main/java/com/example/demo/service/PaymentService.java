package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.model.Transaction;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Iterable<Payment> getAllTransactions(){
        return paymentRepository.findAll();
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public boolean deleteTransaction(Integer id) {
        paymentRepository.delete(paymentRepository.findById(id));
        return true;
    }
}
