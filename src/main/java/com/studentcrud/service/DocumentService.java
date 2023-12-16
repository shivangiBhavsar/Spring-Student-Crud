package com.studentcrud.service;

import org.springframework.web.multipart.MultipartFile;

import com.studentcrud.Model.Document;

public interface DocumentService {

	public Document saveDoc(MultipartFile file);
}
