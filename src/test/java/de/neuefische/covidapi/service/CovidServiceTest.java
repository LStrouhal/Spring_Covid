package de.neuefische.covidapi.service;

import de.neuefische.covidapi.api.CovidApiCountryStatusData;
import de.neuefische.covidapi.api.CovidApiService;
import de.neuefische.covidapi.model.CovidCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CovidServiceTest {

    @Test
    public void getActiveCasesReturnCovidCases() {
        //GIVEN
        CovidApiService covidApiServiceMock = mock(CovidApiService.class);
        CovidService covidService = new CovidService(covidApiServiceMock);

        CovidApiCountryStatusData[] mockedCases = new CovidApiCountryStatusData[]{
                new CovidApiCountryStatusData("Bayern", 100, 50, 400, "2021-02-01T13:13:30Z"),
                new CovidApiCountryStatusData("Hamburg", 10, 80, 300, "2021-02-01T13:13:30Z"),
        };

        when(covidApiServiceMock.getCases()).thenReturn(mockedCases);
        ArrayList<CovidCase> expectedArray = new ArrayList<>();
        expectedArray.add(new CovidCase("Hamburg", 10, "2021-02-01T13:13:30Z"));

        //WHEN
        Optional<List<CovidCase>> activeCases = covidService.getActiveCases();

        //THEN
        assertEquals(activeCases.get(),expectedArray);


    }


}