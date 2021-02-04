package de.neuefische.covidapi.service;


import de.neuefische.covidapi.api.CovidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CovidService {

    private final CovidApiService covidApiService;

    @Autowired
    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }
}
