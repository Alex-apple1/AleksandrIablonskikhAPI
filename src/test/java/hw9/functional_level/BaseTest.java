package hw9.functional_level;

import hw9.assertions.BoardAssertions;
import hw9.assertions.ListAssertions;
import hw9.dto.BoardDTO;
import hw9.dto.ListDTO;
import hw9.service.BoardService;
import hw9.service.ListService;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public BoardDTO boardDTO;
    public BoardService boardService = new BoardService();
    public Map<String, String> parameters = new HashMap<>();
    public BoardAssertions boardAssertions = new BoardAssertions();

    public ListDTO listDTO;
    public ListAssertions listAssertions = new ListAssertions();
    public ListService listService = new ListService();
    public Map<String, String> bodyParametersForListRegistration = new HashMap<>();

    @BeforeTest
    public void createBoard() {
        parameters.put("name", BoardDTO.NAME);
        boardDTO = boardService.createBoard(parameters);
        boardAssertions.assertBoardName(boardDTO, BoardDTO.NAME);
    }

    @AfterTest
    public void deleteBoard() {
        Response response = boardService.deleteBoard(boardDTO.getId());
        boardAssertions.confirmBoardDeletedResponse(response);
    }
}
