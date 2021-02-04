package de.neuefische.covidapi.service;


import de.neuefische.covidapi.api.CovidApiCountryStatusData;
import de.neuefische.covidapi.api.CovidApiService;
import de.neuefische.covidapi.model.CovidCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CovidService {

    private final CovidApiService covidApiService;

    @Autowired
    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }

    public Optional<CovidCases> getActiveCases() {
        CovidApiCountryStatusData[] cases = covidApiService.getCases();
        for (CovidApiCountryStatusData aCase : cases) {
            if (aCase.getProvince().equals("Hamburg")) {
                return Optional.of(new CovidCases(aCase.getProvince(), aCase.getActive(), aCase.getDate()));
            }
        }
        return Optional.empty();

    }

}
