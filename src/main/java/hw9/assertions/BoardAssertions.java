package hw9.assertions;

import static org.testng.Assert.*;

import hw9.entities.BoardDTO;
import io.restassured.response.Response;

public class BoardAssertions {

    public void verifyBoardName(BoardDTO boardDTO, String expected) {
        assertEquals(boardDTO.getName(), expected);
    }

    public void verifyBoardDeletedResponse(Response response) {
        assertNull(response.path("_value"));
    }
}
