package hw9.service;

import hw9.dto.TrelloDto;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;
import static org.testng.Assert.assertEquals;

public class RestCountriesAssertions {
    private TrelloDto[] counties;

    public RestCountriesAssertions(TrelloDto[] response) {
        this.counties = response;
    }

    public RestCountriesAssertions verifyCountry(String countryName) {
        assertEquals(counties.length, 1, "Incorrect list of countries size");
        assertEquals(counties[0].getName(), countryName, "Incorrect county name");
        return this;
    }

    public void verifyCountries(String... countryName) {
        assertEquals(
            stream(counties).map(TrelloDto::getName).collect(toList()).toArray(new String[]{}),
            countryName,
            "Incorrect list of countries");
    }

    public RestCountriesAssertions verifyDataEqual(TrelloDto[] res){
        assertEquals(counties, res);

        return this;
    }
}
