package com.itmo.web.weblab.controllers;

import com.itmo.web.weblab.entities.Query;
import com.itmo.web.weblab.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:10000", "http://localhost:4200"}, allowedHeaders = "*", allowCredentials = "true")
public class QueryController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/query")
    public void doPost(@Valid @RequestBody Query query) {
        query.getResult();
        resultService.save(query);
    }
}
