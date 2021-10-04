package hw9.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "boardServiceDataProvider")
    public static Object[][] boardServiceDataProvider() {
        String secondBoardName = "My old test board";
        String thirdBoardName = "My old testttttttttt board";
        return new Object[][] {
            {secondBoardName},
            {thirdBoardName},
        };
    }
}
