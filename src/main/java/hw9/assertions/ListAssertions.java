package hw9.assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import hw9.dto.ListDTO;
import io.restassured.response.Response;

public class ListAssertions {

    public void assertListName(ListDTO listDTO, String expected) {

        assertEquals(listDTO.getName(), expected);
    }
    public void confirmListDeletedResponse(Response response) {

        assertNull(response.path("_value"));
    }
}
