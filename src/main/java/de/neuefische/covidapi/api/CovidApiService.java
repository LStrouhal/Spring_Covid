package de.neuefische.covidapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CovidApiService {

    private final RestTemplate restTemplate;
    private final String url = "https://api.covid19api.com/live/country/germany/status/confirmed/date/2021-02-01T13:13:30Z";


    @Autowired
    public CovidApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CovidApiCountryStatusData[] getCases() {

        ResponseEntity<CovidApiCountryStatusData[]> response = restTemplate.getForEntity(url, CovidApiCountryStatusData[].class);
        return response.getBody();
    }

}
