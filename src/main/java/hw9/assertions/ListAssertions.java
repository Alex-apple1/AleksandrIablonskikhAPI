package hw9.assertions;

import static org.testng.Assert.assertEquals;

import hw9.entities.List;

public class ListAssertions {

    public void verifyListName(List list, String expected) {
        assertEquals(list.getName(), expected);
    }
}
