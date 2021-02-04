package de.neuefische.covidapi.service;


import de.neuefische.covidapi.api.CovidApiCountryStatusData;
import de.neuefische.covidapi.api.CovidApiService;
import de.neuefische.covidapi.model.CovidCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CovidService {

    private final CovidApiService covidApiService;

    @Autowired
    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }

    public Optional<List<CovidCase>> getActiveCases() {
        CovidApiCountryStatusData[] cases = covidApiService.getCases();
        List<CovidCase> hamburgCases = Arrays.stream(cases)
                .filter(activeCase -> activeCase.getProvince().equals("Hamburg"))
                .map(activeCase-> new CovidCase(activeCase.getProvince(), activeCase.getActive(), activeCase.getDate()))
                .collect(Collectors.toList());

        return Optional.of(hamburgCases);

    }
}
