package com.app.entities;

import org.springframework.web.multipart.MultipartFile;

public class CropImage {

	MultipartFile cropImage;

	public MultipartFile getCropImage() {
		return cropImage;
	}

	public void setCropImage(MultipartFile cropImage) {
		this.cropImage = cropImage;
	}
	
}
