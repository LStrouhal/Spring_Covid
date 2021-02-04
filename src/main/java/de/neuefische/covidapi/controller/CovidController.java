package de.neuefische.covidapi.controller;

import de.neuefische.covidapi.model.CovidCase;
import de.neuefische.covidapi.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("covidcases")
public class CovidController {

    private final CovidService covidService;

    @Autowired
    public CovidController(CovidService covidService) {
        this.covidService = covidService; }

    @GetMapping
    public List<CovidCase> getCovidCases (){
        Optional<List<CovidCase>> activeCases = covidService.getActiveCases();
        if(activeCases.isPresent()){
            return activeCases.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


}
