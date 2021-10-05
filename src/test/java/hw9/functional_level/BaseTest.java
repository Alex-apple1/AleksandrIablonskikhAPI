package hw9.functional_level;

import hw9.assertions.BoardAssertions;
import hw9.entities.BoardDTO;
import hw9.service.BoardService;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public BoardDTO boardDTO;
    public final BoardService boardService = new BoardService();
    public Map<String, String> parameters = new HashMap<>();
    public BoardAssertions boardAssertions = new BoardAssertions();

    @BeforeTest
    public void createBoard() {
        parameters.put("name", BoardDTO.NAME);
        boardDTO = boardService.createBoard(parameters);
        boardAssertions.verifyBoardName(boardDTO, BoardDTO.NAME);
    }

    @AfterTest
    public void deleteBoard() {
        Response response = boardService.deleteBoard(boardDTO.getId());
        boardAssertions.verifyBoardDeletedResponse(response);
    }
}
