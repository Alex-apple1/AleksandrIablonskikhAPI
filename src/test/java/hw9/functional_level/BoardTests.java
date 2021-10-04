package hw9.functional_level;

import hw9.entities.Board;
import hw9.utils.DataProviders;
import org.testng.annotations.Test;

public class BoardTests extends BaseTest {

    @Test(description = "Create, get and delete board test")
    public void createGetDeleteBoardTest() {
        String boardID = board.getId();
        board = boardService.getBoard(boardID);

        ba.verifyBoardName(board, Board.NAME);
    }

    @Test(description = "Create, update and delete board test", dataProvider = "boardServiceDataProvider",
          dataProviderClass = DataProviders.class)
    public void createUpdateDeleteBoardTest(String anotherBoardName) {
        String boardID = board.getId();
        parameters.put("name", anotherBoardName);
        board = boardService.updateBoard(parameters, boardID);

        ba.verifyBoardName(board, anotherBoardName);
    }
}
