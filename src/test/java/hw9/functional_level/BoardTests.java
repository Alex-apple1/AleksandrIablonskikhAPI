package hw9.functional_level;

import hw9.entities.BoardDTO;
import hw9.utils.DataProviders;
import org.testng.annotations.Test;

public class BoardTests extends BaseTest {

    @Test(description = "Create, get and delete board test")
    public void createGetDeleteBoardTest() {
        String boardID = boardDTO.getId();
        boardDTO = boardService.getBoard(boardID);

        boardAssertions.verifyBoardName(boardDTO, BoardDTO.NAME);
    }

    @Test(description = "Create, update and delete board test", dataProvider = "boardServiceDataProvider",
          dataProviderClass = DataProviders.class)
    public void createUpdateDeleteBoardTest(String anotherBoardName) {
        String boardID = boardDTO.getId();
        parameters.put("name", anotherBoardName);
        boardDTO = boardService.updateBoard(parameters, boardID);

        boardAssertions.verifyBoardName(boardDTO, anotherBoardName);
    }
}
