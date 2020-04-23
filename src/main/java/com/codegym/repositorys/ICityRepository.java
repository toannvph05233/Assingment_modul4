package com.codegym.repositorys;

import com.codegym.models.City;
import org.springframework.data.repository.CrudRepository;

public interface ICityRepository extends CrudRepository<City,Long> {
    City findByName(String name);
}
