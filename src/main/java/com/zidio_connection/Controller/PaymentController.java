package com.zidio_connection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio_connection.DTO.PaymentRequestDTO;
import com.zidio_connection.DTO.PaymentResponseDTO;
import com.zidio_connection.Entity.Payment;
import com.zidio_connection.Entity.SubscriptionPlan;
import com.zidio_connection.Repository.PaymentRepository;
import com.zidio_connection.Repository.SubPlanRepository;
import com.zidio_connection.Service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

	@Autowired
	private PaymentService payService;

	@Autowired
	private SubPlanRepository subPlanRepo;

	@Autowired
	private PaymentRepository payRepo;

	@PostMapping("/process")
	public ResponseEntity<PaymentResponseDTO> process(@RequestBody PaymentRequestDTO dto) {
		return ResponseEntity.ok(payService.processPayment(dto));
	}

	@GetMapping("/plans")
	public ResponseEntity<List<SubscriptionPlan>> getPlans() {
		return ResponseEntity.ok(subPlanRepo.findAll());
	}

	@PostMapping("/plans")
	public ResponseEntity<SubscriptionPlan> createPlan(@RequestBody SubscriptionPlan plan) {
		return ResponseEntity.ok(subPlanRepo.save(plan));
	}

	@GetMapping("/history/{userId}")
	public ResponseEntity<List<Payment>> history(@PathVariable String userId) {
		return ResponseEntity.ok(payRepo.findByUserId(userId));
	}
}
