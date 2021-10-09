package hw9.assertions;

import static org.testng.Assert.assertEquals;

import hw9.dto.ListDTO;

public class ListAssertions {

    public void assertListName(ListDTO listDTO, String expected) {

        assertEquals(listDTO.getName(), expected);
    }
}
