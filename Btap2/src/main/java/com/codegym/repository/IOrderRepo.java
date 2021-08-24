package com.codegym.repository;

import com.codegym.model.Oder;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepo extends CrudRepository<Oder , Integer> {
}
