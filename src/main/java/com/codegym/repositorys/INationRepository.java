package com.codegym.repositorys;


import com.codegym.models.Nation;
import org.springframework.data.repository.CrudRepository;

public interface INationRepository extends CrudRepository<Nation,Long> {
    Nation findByName(String name);
}
