package com.zidio_connection.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("String cloudName", "${cloudinary.cloud-name}", "String apiKey",
				"${cloudinary.api-key}", "String apiSecret", "&{cloudinary.api-secret}"));
	}
}
