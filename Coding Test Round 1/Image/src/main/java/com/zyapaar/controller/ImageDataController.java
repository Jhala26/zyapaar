package com.zyapaar.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyapaar.service.ImageDataService;

@RestController
public class ImageDataController {

	@Autowired
	private ImageDataService imService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageData") MultipartFile file) throws IOException{
		
		
		imService.uploadImage(file);
		
	}
	
	
	public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName){
		
		
		byte[] image = imService.downloadImage(fileName);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
		
	}
	
	
}
