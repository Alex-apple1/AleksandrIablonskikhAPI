package hw9.assertions;

import static org.testng.Assert.assertEquals;

import hw9.entities.ListDTO;

public class ListAssertions {

    public void verifyListName(ListDTO listDTO, String expected) {
        assertEquals(listDTO.getName(), expected);
    }
}
