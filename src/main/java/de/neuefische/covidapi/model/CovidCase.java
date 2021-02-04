package de.neuefische.covidapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CovidCase {

    private String province;
    private int active;
    private String date;


}
