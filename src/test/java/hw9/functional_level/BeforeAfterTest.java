package hw9.functional_level;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BeforeAfterTest {
    public Board board;
    public final BoardService boardService = new BoardService();
    public Map<String, String> params = new HashMap<>();
    public BoardAssertions ba = new BoardAssertions();

    @BeforeTest
    public void createABoard() {
        params.put("name", Board.NAME);
        board = boardService.createBoard(params);
        ba.verifyBoardName(board, Board.NAME);
    }

    @AfterTest
    public void deleteABoard() {
        Response rs = boardService.deleteBoard(board.getId());
        ba.verifyBoardDeletedResponse(rs);
    }
}
