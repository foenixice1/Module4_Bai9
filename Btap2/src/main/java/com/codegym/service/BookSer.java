package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookSer {
    @Autowired
    IBookRepo iBookRepo ;

    public ArrayList<Book> findAll(){
        return (ArrayList<Book>) iBookRepo.findAll();
    }

    public Book findById(int id){
        return  iBookRepo.findById(id).get();
    }
    public Book save(Book book){
        return  iBookRepo.save(book);
    }
}
