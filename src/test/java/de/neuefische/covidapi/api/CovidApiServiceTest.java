package de.neuefische.covidapi.api;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CovidApiServiceTest {

    private final String url = "https://api.covid19api.com/live/country/germany/status/confirmed/date/2021-02-01T13:13:30Z";

    @Test

    public void getCasesRetunsCovidData() {

        //GIVEN

        RestTemplate restTemplate = mock(RestTemplate.class);

        CovidApiCountryStatusData[] mockedData = {
                new CovidApiCountryStatusData("Bayern", 100, 50, 400, "2021-02-01T13:13:30Z"),
                new CovidApiCountryStatusData("Sachsen", 200, 80, 1000, "2021-02-01T13:13:30Z"),
        };

        when(restTemplate.getForEntity(url, CovidApiCountryStatusData[].class)).thenReturn(new ResponseEntity<>(mockedData, HttpStatus.OK));

        CovidApiService testCovidApiService = new CovidApiService(restTemplate);

        //WHEN

        CovidApiCountryStatusData[] testCases = testCovidApiService.getCases();

        //THEN

        assertThat(testCases, arrayContaining(
                new CovidApiCountryStatusData("Bayern", 100, 50, 400, "2021-02-01T13:13:30Z"),
                new CovidApiCountryStatusData("Sachsen", 200, 80, 1000, "2021-02-01T13:13:30Z")
                ));

    }

}