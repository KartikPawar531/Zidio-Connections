package com.zidio_connection.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SubscriptionStatusDTO {

	private int totalPayments;
	private int paidUsers;
	private int activePlans;
	private double totalRevenue;
	private double averageRevenuePerUser;
}
