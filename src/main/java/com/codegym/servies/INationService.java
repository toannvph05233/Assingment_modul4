package com.codegym.servies;

import com.codegym.models.Nation;

public interface INationService {
    Iterable<Nation> findAll();

    Nation findById(Long id);

    void save(Nation nation);

    void remove(Long id);

    Nation findByName(String name);
}
