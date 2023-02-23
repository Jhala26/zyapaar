package com.zyapaar.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.zyapaar.model.ImageData;

public interface ImageDataService {

	public ImageData uploadImage(MultipartFile file)throws IOException;
	
	public byte[] downloadImage(String fileName);
	
}
