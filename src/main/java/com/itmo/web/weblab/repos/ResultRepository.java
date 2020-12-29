package com.itmo.web.weblab.repos;

import com.itmo.web.weblab.entities.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Query, Integer> {
    
}
