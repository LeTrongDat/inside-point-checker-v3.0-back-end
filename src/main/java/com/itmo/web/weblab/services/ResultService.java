package com.itmo.web.weblab.services;

import com.itmo.web.weblab.entities.Query;
import com.itmo.web.weblab.repos.ResultRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter @Setter
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public List<Query> findAll() {
        List<Query> queries = new ArrayList<>();

        resultRepository.findAll().forEach(queries::add);

        return queries;
    }

    public void save(Query query) {
        resultRepository.save(query);
    }

    public void clear() {
        resultRepository.deleteAll();
    }
}
