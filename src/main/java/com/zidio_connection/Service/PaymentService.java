package com.zidio_connection.Service;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zidio_connection.DTO.PaymentRequestDTO;
import com.zidio_connection.DTO.PaymentResponseDTO;
import com.zidio_connection.Entity.Payment;
import com.zidio_connection.Enum.PaymentStatus;
import com.zidio_connection.Repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private GenerateInvoiceService invoiceService;

	public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {
		Payment pay = new Payment();
		pay.setUserId(dto.getUserId());
		pay.setPlanId(dto.getPlanId());
		pay.setAmount(dto.getAmount());
		pay.setCurrency(dto.getCurrency());
		pay.setPaymentType(dto.getPaymentType());
		pay.setPaymentStatus(PaymentStatus.SUCCESS);
		pay.setTransactionId(UUID.randomUUID().toString());
		pay.setTimeStamp(LocalDateTime.now());

		paymentRepo.save(pay);

		byte[] pdfBytes = invoiceService.generateInvoice(pay);
		String filePath = "Invoices/Invoice-" + pay.getTransactionId() + ".pdf";

		try (FileOutputStream fos = new FileOutputStream(filePath)) {
			fos.write(pdfBytes);
		} catch (Exception e) {
			throw new RuntimeException("Error saving Invoice Pdf", e);
		}

		RestTemplate restTemplete = new RestTemplate();
		String notifyURL = "http://localhost:6666/api/notify/send-invoice";
		restTemplete.postForObject(notifyURL
				+ "?to=user@email.com&cubject=Your Invoice&body=Pleasefind attached your invoice.&filePah=" + filePath,
				null, String.class);

		PaymentResponseDTO response = new PaymentResponseDTO();
		response.setTransactionId(pay.getTransactionId());
		response.setPaymentStatus(pay.getPaymentStatus());
		response.setCurrency(pay.getCurrency());
		response.setAmount(pay.getAmount());

		return response;
	}
}
