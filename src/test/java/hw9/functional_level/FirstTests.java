//package hw9.functional_level;
//
//import static org.testng.Assert.assertEquals;
//
//import hw9.dto.TrelloDto;
//import hw9.service.RestCountriesService;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class FirstTests {
//    @Test(description = "Get a Board by id")
//    public void getBoardByIdTest() {
//        String boardId = "61589aa634554182356e00ae";
//
//        TrelloDto[] boardName = new RestCountriesService().getBoardById(boardId);
//
//        assertEquals(boardName.length, 1, "Incorrect list of countries");
//        assertEquals(boardName[0].getName(), boardId, "Incorrect Board name");
//    }
//
//    @Test(description = "Get country by one Code")
//    void getCountryByCode() {
//        String countryCode = "rus";
//        String countryName = "Russia";
//
//        TrelloDto[] country = new RestCountriesService().getCountryByCode(countryCode);
//
//        assertEquals(country.length, 1, "Incorrect list of countries");
//        assertEquals(country[0].getName(), countryName, "Incorrect county name");
//    }
//
//    //----------------------------------------Custom assertion
//    @Test(description = "Get country by one Code")
//    void getCountrytByCode2() {
//        String countryCode = "rus";
//        String countryName = "Russia";
//
//        TrelloDto[] countriesRussia = new TrelloDto[]{
//            new TrelloDto().setName("Russia")
//        };
//
//        TrelloDto[] countriesActual = new RestCountriesService()
//            .getCountryByCode(countryCode);
//
//        new RestCountriesAssertions(countriesActual)
//            .verifyDataEqual(countriesRussia)
//            .verifyCountry(countryName)
//            .verifyCountries(countryName, countryName);
//    }
//
//    @Test(description = "Get country by one Code")
//    void getCountryByTwoCode2() {
//        String countryCode = "rus;nor";
//
//        TrelloDto[] countries = new RestCountriesService()
//            .getCountryByCode(countryCode);
//
//        new RestCountriesAssertions(countries)
//            .verifyCountries("Russia", "Norway");
//    }
//
//    //-----------------------------------Data Provider
//
//    @DataProvider
//    public Object[][] countriesData() {
//        return new Object[][]{
//            {"PYATEROCHKA_1", "rus", "Russia"},
//            {"PYATEROCHKA_6", "rus;nor", "Russia", "Norway"},
//            {"PYATEROCHKA_89", "rus;nor", "Russia", "Norway"},
//            {"PYATEROCHKA_76_1", "ua", "Ukraine"},
//            {"PYATEROCHKA_76_2", "rus;nor", "Angola", "Norway"},
//            {"PYATEROCHKA_76_3", "rus;nor", "Russia", "Norway"},
//        };
//    }
//
//    @Test(description = "Get country by one Code", dataProvider = "countriesData")
//    void getCountryByTwoCodeMultiple(String testId, String countryCodes, String... expectedCountriesNames) {
//
//        TrelloDto[] countries = new RestCountriesService()
//            .getCountryByCode(countryCodes);
//
//        new RestCountriesAssertions(countries)
//            .verifyCountries(expectedCountriesNames);
//    }
//
//}
