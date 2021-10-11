package hw9.functional_level;

import hw9.dto.BoardDTO;
import hw9.data.DataProviders;
import hw9.dto.ListDTO;
import io.restassured.response.Response;
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

    @Test(description = "Create board, delete board and check if board is deleted test from DataProvider",
          dataProvider = "boardServiceDataProvider",
          dataProviderClass = DataProviders.class
    )
    public void createDeleteCheckIfBoardIsDeletedTest(String boardName) {

        String boardID = boardDTO.getId();
        Response response = boardService.deleteBoard(boardID);

        boardAssertions.confirmBoardDeletedResponse(response);
    }

    @Test(description = "Create list, delete board and check result test")
    public void createListDeleteBoardTest() {
        bodyParametersForListRegistration.put("name", ListDTO.NAME);
        bodyParametersForListRegistration.put("idBoard", boardDTO.getId());
        listDTO = listService.createList(bodyParametersForListRegistration);
        Response response = boardService.deleteBoard(boardDTO.getId());

        listAssertions.confirmListDeletedResponse(response);
    }

    @Test(description = "Create list, delete list and check result test")
    public void createListDeleteListDeleteListAgainTest() {

        bodyParametersForListRegistration.put("name", ListDTO.NAME);
        bodyParametersForListRegistration.put("idBoard", boardDTO.getId());

        listDTO = listService.createList(bodyParametersForListRegistration);

        Response response = listService.deleteList(listDTO.getId());

        listAssertions.confirmListDeletedResponse(response);
    }
}
