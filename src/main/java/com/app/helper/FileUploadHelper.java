package com.app.helper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Component
public class FileUploadHelper {

	public FileUploadHelper() {
	}

	// this function is calling the api of python and then gives us the final
	// response i.e. CropDetectionResponse entity
	public String sendingToML(MultipartFile file) throws IOException {
		// sending image to python

		String url = "http://127.0.0.1:5000/predict";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofByteArray(file.getBytes())).build();
		HttpClient client = HttpClient.newHttpClient();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (Exception e) {
			e.printStackTrace();
			return "not found";
		}

	}

}
