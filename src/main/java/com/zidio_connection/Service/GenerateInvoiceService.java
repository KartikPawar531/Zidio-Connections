package com.zidio_connection.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.zidio_connection.Entity.Payment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenerateInvoiceService {

	public byte[] generateInvoice(Payment payment) {

		try {
			Document doc = new Document();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(doc, baos);
			doc.open();

			Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
			Paragraph title = new Paragraph("Payment Invoice Copy", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			doc.add(title);

			doc.add(new Paragraph(" "));
			doc.add(new Paragraph("Invoice Id:-" + payment.getTransactionId()));
			doc.add(new Paragraph("User Id:-" + payment.getUserId()));
			doc.add(new Paragraph("Subscription Plan Id:-" + payment.getPlanId()));
			doc.add(new Paragraph("Currency:-" + payment.getCurrency()));
			doc.add(new Paragraph("Amount Paid:-" + payment.getAmount()));
			doc.add(new Paragraph("Payment Status:-" + payment.getPaymentStatus()));
			doc.add(new Paragraph("Date:-" + payment.getTimeStamp()));

			doc.add(new Paragraph(" "));
			doc.add(new Paragraph("Thank You For Using Zidio"));
			doc.close();

			return baos.toByteArray();

		} catch (Exception e) {
			throw new RuntimeException("Error Generating Invoic Copy", e);
		}
	}
}
