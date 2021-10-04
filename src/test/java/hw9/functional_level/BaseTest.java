package hw9.functional_level;

import hw9.assertions.BoardAssertions;
import hw9.entities.Board;
import hw9.service.BoardService;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public Board board;
    public final BoardService boardService = new BoardService();
    public Map<String, String> parameters = new HashMap<>();
    public BoardAssertions ba = new BoardAssertions();

    @BeforeTest
    public void createABoard() {
        parameters.put("name", Board.NAME);
        board = boardService.createBoard(parameters);
        ba.verifyBoardName(board, Board.NAME);
    }

    @AfterTest
    public void deleteABoard() {
        Response rs = boardService.deleteBoard(board.getId());
        ba.verifyBoardDeletedResponse(rs);
    }
}
