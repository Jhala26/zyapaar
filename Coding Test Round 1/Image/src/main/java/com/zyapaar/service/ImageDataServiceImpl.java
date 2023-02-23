package com.zyapaar.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyapaar.model.ImageData;
import com.zyapaar.repository.ImageDataRepository;
import com.zyapaar.util.ImageUtil;

@Service
public class ImageDataServiceImpl implements ImageDataService{

	@Autowired
	private ImageDataRepository imageRepo;
	
	
	@Override
	public ImageData uploadImage(MultipartFile file) throws IOException {
		
		ImageData img = new ImageData();
		
		img.setName(file.getOriginalFilename());
		img.setType(file.getContentType());
		img.setImageData(ImageUtil.compressImage(file.getBytes()));
		
		return imageRepo.save(img);
	}

	@Override
	public byte[] downloadImage(String fileName) {
		
		Optional<ImageData> imageData = imageRepo.findByName(fileName);
		
		return ImageUtil.decompressImage(imageData.get().getImageData());
	}

}
