package com.zidio_connection.Entity;

import java.time.LocalDateTime;

import com.zidio_connection.Enum.PaymentStatus;
import com.zidio_connection.Enum.PaymentType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userId;
	private Long planId;
	private Double amount;
	private String currency;
	private PaymentStatus paymentStatus;
	private PaymentType paymentType;
	private String transactionId;
	private LocalDateTime timeStamp;
}
