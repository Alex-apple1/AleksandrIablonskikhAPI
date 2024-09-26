package hw9.assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import hw9.dto.BoardDTO;
import hw9.dto.ListDTO;
import io.restassured.response.Response;

public class ListAssertions {

    public void assertListName(ListDTO listDTO, String expected) {

        assertEquals(listDTO.getName(), expected);
    }
    public void confirmListDeletedResponse(Response response) {

        assertNull(response.path("_value"));
    }

    public void confirmListIsNotClosed(ListDTO listDTO, boolean expected) {

        assertEquals(listDTO.isClosed(), expected);
    }

}
