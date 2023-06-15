package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.MyBookList;
import com.example.repository.MyBookListRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookListRepository repo;
	
	public void saveMyBooks(MyBookList bookList) {
		repo.save(bookList);
	}
	
	public List<MyBookList> getAllMyBooks() {
		return repo.findAll();
	}
	
	public  void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
