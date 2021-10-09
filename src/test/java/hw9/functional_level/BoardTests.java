package hw9.functional_level;

import hw9.dto.BoardDTO;
import hw9.data.DataProviders;
import hw9.dto.ListDTO;
import org.testng.annotations.Test;

public class BoardTests extends BaseTest {

    @Test(description = "Simple test")
    public void createSimpleBoardTest() {

        parameters.put("name", BoardDTO.NAME);
        boardDTO = boardService.createBoard(parameters);
        boardAssertions.assertBoardName(boardDTO, BoardDTO.NAME);
    }

    @Test(description = "Create, get and assert first board name test")
    public void createGetAssertBoardNameTest() {

        String boardID = boardDTO.getId();
        boardDTO = boardService.getBoard(boardID);

        boardAssertions.assertBoardName(boardDTO, BoardDTO.NAME);
    }

    @Test(description = "Create, delete and check if board is deleted test from DataProvider",
          dataProvider = "boardServiceDataProvider",
          dataProviderClass = DataProviders.class
    )
    public void createDeleteCheckIfBoardIsDeletedTest(String boardName) {

        String boardID = boardDTO.getId();
        parameters.put("name", boardName);
        boardDTO = boardService.updateBoard(parameters, boardID);

        boardAssertions.assertBoardName(boardDTO, boardName);
    }

    @Test(description = "Create list, delete board and check result test")
    public void createListDeleteBoardTest() {
        bodyParametersForRegistration.put("name", ListDTO.NAME);
        bodyParametersForRegistration.put("idBoard", boardDTO.getId());
        listDTO = listService.createList(bodyParametersForRegistration);

        listAssertions.assertListName(listDTO, ListDTO.NAME);
    }

    @Test(description = "Create list, delete list and delete list again with result check test")
    public void createListDeleteListDeleteListAgainTest() {
        String changedName = "ToDo test list changed";
        bodyParametersForRegistration.put("name", ListDTO.NAME);
        parameters.put("idBoard", boardDTO.getId());

        listDTO = listService.createList(bodyParametersForRegistration);
        String listID = listDTO.getId();

        bodyParametersForRegistration.put("name", changedName);
        listDTO = listService.updateList(listID, bodyParametersForRegistration);

        listAssertions.assertListName(listDTO, changedName);
    }
}
