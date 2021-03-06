package com.example.library.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.model.*;
import com.example.library.service.UploadService;

@RestController
public class UploadController {

	@Autowired
	UploadService uploadService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/writeExcel",method = RequestMethod.POST) 
    public void updateExcel(@RequestBody BookTabStruct obj ) throws IOException {

		System.out.println("inside updateExcel");

	    uploadService.excelUpdateService(obj);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/readExcel")
	public List<BookTabStruct> readExcel() throws Exception
	{
		return uploadService.readBooksData();
	}
	
}
