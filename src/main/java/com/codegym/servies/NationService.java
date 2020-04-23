package com.codegym.servies;

import com.codegym.models.Nation;
import com.codegym.repositorys.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NationService implements INationService {

    @Autowired
    INationRepository iNationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return iNationRepository.findAll();
    }

    @Override
    public Nation findById(Long id) {
        return iNationRepository.findOne(id);
    }

    @Override
    public void save(Nation nation) {
        iNationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
        iNationRepository.delete(id);
    }

    @Override
    public Nation findByName(String name) {
        return iNationRepository.findByName(name);
    }
}
