package yandexSpeller.servise;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;

import yandexSpeller.dto.SpellerDTO;

public class SpellerAssertions {
    private SpellerDTO[] spellerDTOS;

    public SpellerAssertions(SpellerDTO[] response) {
        this.spellerDTOS = response;
    }

    public SpellerAssertions verifyCountry(String countryName) {
        assertEquals(spellerDTOS.length, 1, "Incorrect list of words");
        assertEquals(spellerDTOS[0].getWord(), countryName, "Incorrect word");
        return this;
    }

    public void verifyCountries(String... countryName) {
        assertEquals(
            stream(spellerDTOS).map(SpellerDTO::getWord).collect(toList()).toArray(new String[]{}),
            countryName,
            "Incorrect list of words");
    }

    public SpellerAssertions verifyDataEqual(SpellerDTO[] res){
        assertEquals(spellerDTOS, res);

        return this;
    }
}
