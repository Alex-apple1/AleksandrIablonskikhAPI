package hw9.assertions;

import static org.testng.Assert.*;

import hw9.entities.Board;
import io.restassured.response.Response;

public class BoardAssertions {

    public void verifyBoardName(Board board, String expected) {
        assertEquals(board.getName(), expected);
    }

    public void verifyBoardDeletedResponse(Response response) {
        assertNull(response.path("_value"));
    }
}
