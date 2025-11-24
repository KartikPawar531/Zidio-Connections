package com.zidio_connection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio_connection.Entity.Payment;
import com.zidio_connection.Repository.PaymentRepository;
import com.zidio_connection.Service.GenerateInvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class GenerateInvoiceController {

	@Autowired
	private GenerateInvoiceService generateInvoice;

	@Autowired
	private PaymentRepository payRepo;

	@GetMapping("/invoice/{paymentId}")
	public ResponseEntity<byte[]> downloadInvoice(@PathVariable Long paymentId) {
		Payment pay = payRepo.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));

		byte[] pdfbytes = generateInvoice.generateInvoice(pay);
		return ResponseEntity.ok()
				.header("Content-Disposition", "Attachment; fileName=invoice-" + pay.getTransactionId() + ".pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(pdfbytes);
	}
}
