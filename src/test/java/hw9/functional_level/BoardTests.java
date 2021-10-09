package hw9.functional_level;

import hw9.dto.BoardDTO;
import hw9.data.DataProviders;
import org.testng.annotations.Test;

public class BoardTests extends BaseTest {

    @Test(description = "Create, get and assert board name test")
    public void createGetAssertBoardNameTest() {

        String boardID = boardDTO.getId();
        boardDTO = boardService.getBoard(boardID);

        boardAssertions.assertBoardName(boardDTO, BoardDTO.NAME);
    }

    @Test(description = "Create, delete and check if board is deleted test",
          dataProvider = "boardServiceDataProvider",
          dataProviderClass = DataProviders.class)
    public void createDeleteCheckIfBoardIsDeletedTest(String anotherBoardName) {

        String boardID = boardDTO.getId();
        parameters.put("name", anotherBoardName);
        boardDTO = boardService.updateBoard(parameters, boardID);

        boardAssertions.assertBoardName(boardDTO, anotherBoardName);
    }
}
