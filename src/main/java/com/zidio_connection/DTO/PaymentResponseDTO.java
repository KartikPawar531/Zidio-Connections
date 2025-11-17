package com.zidio_connection.DTO;

import com.zidio_connection.Enum.PaymentStatus;
import com.zidio_connection.Enum.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PaymentResponseDTO {

	private String transactionId;
	private PaymentStatus paymentStatus;
	private String currency;
	private Double amount;
}
