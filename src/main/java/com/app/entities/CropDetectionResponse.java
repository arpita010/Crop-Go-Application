package com.app.entities;

import com.google.gson.Gson;

public class CropDetectionResponse {
//	private String imageFileName;
	private String predictedDisease;
	private String description;
	private String symptoms;

//	public String getImageFileName() {
//		return imageFileName;
//	}

	public String getPredictedDisease() {
		return predictedDisease;
	}

	public String getDescription() {
		return description;
	}

	public String getSymptoms() {
		return symptoms;
	}

//	public void setImageFileName(String imageFileName) {
//		this.imageFileName = imageFileName;
//	}

	public void setPredictedDisease(String predictedDisease) {
		this.predictedDisease = predictedDisease;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

}
