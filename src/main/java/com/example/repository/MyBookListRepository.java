package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.MyBookList;

@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList, Integer> {

}
