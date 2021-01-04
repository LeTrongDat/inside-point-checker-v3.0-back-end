package com.itmo.web.weblab.controllers;

import com.itmo.web.weblab.entities.Query;
import com.itmo.web.weblab.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/result")
    public List<Query> doGet() {
        List<Query> result = resultService.findAll();

        Collections.reverse(result);

        return result;
    }

    @GetMapping("/clear")
    public void doClear() {
        resultService.clear();
    }
}
