package com.zidio_connection.DTO;

import com.zidio_connection.Enum.PaymentStatus;
import com.zidio_connection.Enum.PaymentType;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PaymentRequestDTO {

	private String userId;
	private Long planId;
	private String currency;
	private Double amount;
	private PaymentType paymentType;
	private PaymentStatus paymentStatus;
}
