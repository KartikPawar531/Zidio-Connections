package com.zidio_connection.Controller;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio_connection.DTO.EmailRequestDTO;
import com.zidio_connection.Service.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public ResponseEntity<String> send(@RequestBody EmailRequestDTO dto) {
		emailService.sendEmail(dto);
		return ResponseEntity.ok("Email Sent successfully");
	}

	@PostMapping("/send-invoice")
	public ResponseEntity<String> sendInvoice(@RequestBody EmailRequestDTO dto, @RequestParam String filePath)
			throws IOException {
		File file = new File(filePath);

		if (!file.exists()) {
			return ResponseEntity.badRequest().body("File not found at path :" + filePath);
		}
		emailService.sendEmailWithAttachmentFile(dto, file);
		return ResponseEntity.ok("Invoice Email sent SuccessFully..!!!");
	}
}
