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
    public Map<String, String> bodyParametersForBoardRegistration = new HashMap<>();
    public BoardAssertions boardAssertions = new BoardAssertions();

    public ListDTO listDTO;
    public ListService listService = new ListService();
    public Map<String, String> bodyParametersForListRegistration = new HashMap<>();
    public ListAssertions listAssertions = new ListAssertions();

    @BeforeTest
    public void createBoard() {
        bodyParametersForBoardRegistration.put("name", BoardDTO.NAME);
        boardDTO = boardService.createBoard(bodyParametersForBoardRegistration);
        boardAssertions.assertBoardName(boardDTO, BoardDTO.NAME);
    }

    @AfterTest
    public void deleteBoard() {
        Response response = boardService.deleteBoard(boardDTO.getId());
        boardAssertions.confirmBoardDeletedResponse(response);
    }
}
