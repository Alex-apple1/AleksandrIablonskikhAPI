package hw9.functional_level;

import hw9.service.ListService;
import hw9.assertions.ListAssertions;
import hw9.dto.ListDTO;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class ListTests extends BaseTest{

    private ListDTO listDTO;
    private final ListAssertions listAssertions = new ListAssertions();
    private final ListService listService = new ListService();
    private final Map<String, String> bodyParametersForRegistration = new HashMap<>();

    @Test(description = "Create list, delete board and check result test")
    public void createListDeleteBoardTest() {
        bodyParametersForRegistration.put("name", ListDTO.NAME);
        bodyParametersForRegistration.put("idBoard", boardDTO.getId());
        listDTO = listService.createList(bodyParametersForRegistration);

        listAssertions.assertListName(listDTO, ListDTO.NAME);
    }

    @Test(description = "Create list, delete list and delete again list with result check test")
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
