package com.nt.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface GstProductService {

	boolean saveDataFromUploadFile(MultipartFile file);

	int findGstRate();
}