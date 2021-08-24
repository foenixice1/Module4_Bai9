package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepo extends CrudRepository<Book, Integer> {
}
