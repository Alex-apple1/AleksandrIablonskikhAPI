package hw9.functional_level;

import hw9.dto.BoardDTO;
import hw9.data.DataProviders;
import hw9.dto.ListDTO;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BoardTests extends BaseTest {

    @Test(description = "Simple board test")
    public void createSimpleBoardTest() {

        bodyParametersForBoardRegistration.put("name", BoardDTO.NAME);
        boardDTO = boardService.createBoard(bodyParametersForBoardRegistration);
        boardAssertions.assertBoardName(boardDTO, BoardDTO.NAME);
    }

    @Test(description = "Create board, get board and assert first board name test")
    public void createBoardGetAssertBoardNameTest() {

        String boardID = boardDTO.getId();
        boardDTO = boardService.getBoard(boardID);

        boardAssertions.assertBoardName(boardDTO, BoardDTO.NAME);
    }

    @Test(description = "Create board, delete board and check if board is deleted. Test from DataProvider",
          dataProvider = "boardServiceDataProvider",
          dataProviderClass = DataProviders.class
    )
    public void createBoardDeleteBoardTest(String boardName) {

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
    public void createListDeleteListTest() {

        bodyParametersForListRegistration.put("name", ListDTO.NAME);
        bodyParametersForListRegistration.put("idBoard", boardDTO.getId());

        listDTO = listService.createList(bodyParametersForListRegistration);

        Response response = listService.deleteList(listDTO.getId());

        listAssertions.confirmListDeletedResponse(response);
    }

    //Additional Tests

    @Test(description = "Create list, update list and check result test")
    public void createListUpdateListTest() {

        String newListName = "New List name for update";
        bodyParametersForListRegistration.put("name", ListDTO.NAME);
        bodyParametersForListRegistration.put("idBoard", boardDTO.getId());

        listDTO = listService.createList(bodyParametersForListRegistration);
        String listID = listDTO.getId();

        bodyParametersForListRegistration.put("name", newListName);
        listDTO = listService.updateList(listID, bodyParametersForListRegistration);

        listAssertions.assertListName(listDTO, newListName);
    }

    @Test(description = "Create board, update board and assert board second name test")
    public void createBoardUpdateBoardAssertBoardNameTest() {

        String newBoardName = "New Board name for update";
        String boardID = boardDTO.getId();

        bodyParametersForBoardRegistration.put("name", newBoardName);

        boardDTO = boardService.updateBoard(bodyParametersForBoardRegistration, boardID);

        boardAssertions.assertBoardName(boardDTO, newBoardName);
    }


}
