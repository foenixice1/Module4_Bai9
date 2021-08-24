package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.Oder;
import com.codegym.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OderSer {
    @Autowired
    IOrderRepo iOrderRepo;

    public ArrayList<Oder> findAll(){
        return (ArrayList<Oder>) iOrderRepo.findAll();
    }

    public Oder findById(int id){
        return  iOrderRepo.findById(id).get();
    }
    public Oder save(Oder oder){
        return  iOrderRepo.save(oder);
    }
}
