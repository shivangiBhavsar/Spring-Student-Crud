package com.studentcrud.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentcrud.Model.Document;
import com.studentcrud.Model.Student;


@Repository
public interface DocumentRepository  extends CrudRepository<Document, Integer>{

	Document save(Document doc);
}
