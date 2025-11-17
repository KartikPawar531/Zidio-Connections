package com.zidio_connection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zidio_connection.Service.FileUploadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/upload")
@RequiredArgsConstructor
public class FileUploadController {

	@Autowired
	private FileUploadService fileUpload;
	
	@PostMapping("/resume")
	public ResponseEntity<String>uploadResume(@RequestParam("file")MultipartFile file) throws Exception{
		return ResponseEntity.ok(fileUpload.uploadFile(file, "Resume"));
	}
	
	@PostMapping("/image")
	public ResponseEntity<String>uploadCertificate(@RequestParam("file")MultipartFile file) throws Exception{
		return ResponseEntity.ok(fileUpload.uploadFile(file, "Image"));
	}	
}
