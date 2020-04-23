package com.codegym.servies;

import com.codegym.models.City;

public interface ICityService  {
    Iterable<City> findAll();

    City findById(Long id);

    void save(City city);

    void remove(Long id);

    City findByName(String name);
}
