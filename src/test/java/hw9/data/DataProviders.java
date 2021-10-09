package hw9.data;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "boardServiceDataProvider")
    public static Object[][] boardServiceDataProvider() {
        String secondBoardName = "My second test board";
        String thirdBoardName = "My third board";
        return new Object[][] {
            {secondBoardName},
            {thirdBoardName},
        };
    }
}
