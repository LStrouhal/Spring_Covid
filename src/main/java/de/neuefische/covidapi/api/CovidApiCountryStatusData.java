package de.neuefische.covidapi.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CovidApiCountryStatusData {

    @JsonProperty("Province")
    private String province;
    @JsonProperty("Active")
    private int active;
    @JsonProperty("Deaths")
    private int deaths;
    @JsonProperty("Confirmed")
    private int confirmed;
    @JsonProperty("Date")
    private String date;


}
