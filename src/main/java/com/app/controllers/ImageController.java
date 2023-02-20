package com.app.controllers;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.entities.CropDetectionResponse;
import com.app.entities.CropImage;
import com.app.helper.FileUploadHelper;
import com.google.gson.Gson;


@RestController
@CrossOrigin(maxAge = 3600,origins = "*")
public class ImageController {
	
	@Autowired
	FileUploadHelper helper;
	
	@ResponseBody
	@PostMapping(path="/upload",consumes="multipart/form-data")
	public ResponseEntity<CropDetectionResponse> getCropImage(@RequestParam("crop-image") MultipartFile data)throws IOException
	{
		System.out.println("upload function run");
		
		System.out.println(data.getOriginalFilename());
		
		CropImage img=new CropImage();

		img.setCropImage(data);
		
		String response=helper.sendingToML(img.getCropImage());
		
		System.out.println(response);
		
		CropDetectionResponse detectionResult=new Gson().fromJson(response, CropDetectionResponse.class);
		
		return ResponseEntity.of(Optional.of(detectionResult));
	}
	@ResponseBody
	@GetMapping("/")
	public String homePage()
	{
		return "Welcome to our crop-go website";
	}
	@PostMapping("/data")
	public String formData()
	{
		return "aagya data";
	}
}
