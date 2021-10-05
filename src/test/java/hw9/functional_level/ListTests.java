package hw9.functional_level;

import hw9.service.ListService;
import hw9.assertions.ListAssertions;
import hw9.entities.ListDTO;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class ListTests extends BaseTest{

    private ListDTO listDTO;
    private ListAssertions listAssertions = new ListAssertions();
    private final ListService listService = new ListService();
    private Map<String, String> bodyParametersForRegistration = new HashMap<>();

    @Test(description = "Create list and delete board test")
    public void createListDeleteBoardTest() {
        bodyParametersForRegistration.put("name", ListDTO.NAME);
        bodyParametersForRegistration.put("idBoard", boardDTO.getId());
        listDTO = listService.createList(bodyParametersForRegistration);

        listAssertions.verifyListName(listDTO, ListDTO.NAME);
    }

    @Test(description = "Create, delete list and delete board test")
    public void createUpdateListDeleteBoardTest() {
        String changedName = "ToDo test list changed";
        bodyParametersForRegistration.put("name", ListDTO.NAME);
        parameters.put("idBoard", boardDTO.getId());

        listDTO = listService.createList(bodyParametersForRegistration);
        String listID = listDTO.getId();

        bodyParametersForRegistration.put("name", changedName);
        listDTO = listService.updateList(listID, bodyParametersForRegistration);

        listAssertions.verifyListName(listDTO, changedName);
    }
}
