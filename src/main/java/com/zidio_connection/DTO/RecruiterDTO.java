package com.zidio_connection.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class RecruiterDTO {

	private String companyEmail;
	private String companyName;
	private String recruiterNumber;
	private String companyWebsite;
	private String companyLocation;
	private String recruiterName;
}
