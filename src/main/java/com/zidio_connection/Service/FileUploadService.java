package com.zidio_connection.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadService {

	@Autowired
	private Cloudinary cloudinary;

	public FileUploadService(@Value("${cloudinary.cloud-name}") String cloudName,
			@Value("${cloudinary.api-key}") String apiKey, @Value("&{cloudinary.api-secret}") String apiSecret) {

		this.cloudinary = new Cloudinary(
				ObjectUtils.asMap("cloud-name", cloudName, "api-key", apiKey, "api-secret", apiSecret));
	}

	public String uploadFile(MultipartFile file, String folder) throws IOException {
		String uploadDIR = "uploads";

		Path uploadPath = Paths.get(uploadDIR);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		String filePath = uploadPath.resolve(file.getOriginalFilename()).toString();
		file.transferTo(new File(filePath));

		Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", folder));

		return (String) uploadResult.get("secure_url");
	}
}
