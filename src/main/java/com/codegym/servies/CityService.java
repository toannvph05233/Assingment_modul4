package com.codegym.servies;

import com.codegym.models.City;
import com.codegym.repositorys.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class CityService implements ICityService {

    @Autowired
    private ICityRepository iCityRepository;

    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return iCityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        iCityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        iCityRepository.delete(id);
    }

    @Override
    public City findByName(String name) {
        return iCityRepository.findByName(name);
    }
}
