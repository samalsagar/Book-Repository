package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public void save(Book book) {
		repo.save(book);
	}
	
	
	public List<Book> getAllBooks() {
		
		return repo.findAll();
	}
	
	public Book getbookById(Integer id) {
		
		return repo.findById(id).get();
		
	}
	
	public void deletebyId(Integer id) {
		 repo.deleteById(id);
	}
}
