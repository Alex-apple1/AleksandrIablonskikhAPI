package hw9.assertions;

import static org.testng.Assert.*;

import hw9.dto.BoardDTO;
import io.restassured.response.Response;

public class BoardAssertions {

    public void assertBoardName(BoardDTO boardDTO, String expected) {

        assertEquals(boardDTO.getName(), expected);
    }

    public void confirmBoardDeletedResponse(Response response) {

        assertNull(response.path("_value"));
    }
}
