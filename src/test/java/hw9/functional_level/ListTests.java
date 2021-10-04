package hw9.functional_level;

import hw9.service.ListService;
import hw9.assertions.ListAssertions;
import hw9.entities.List;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class ListTests extends BaseTest{

    private List list;
    private ListAssertions la = new ListAssertions();
    private final ListService listService = new ListService();
    private Map<String, String> bodyParametersForRegistration = new HashMap<>();

    @Test(description = "Create list and delete board test")
    public void createListDeleteBoardTest() {
        bodyParametersForRegistration.put("name", List.NAME);
        bodyParametersForRegistration.put("idBoard", board.getId());
        list = listService.createList(bodyParametersForRegistration);

        la.verifyListName(list, List.NAME);
    }

    @Test(description = "Create, delete list and delete board test")
    public void createUpdateListDeleteBoardTest() {
        String changedName = "ToDo test list changed";
        bodyParametersForRegistration.put("name", List.NAME);
        parameters.put("idBoard", board.getId());

        list = listService.createList(bodyParametersForRegistration);
        String listID = list.getId();

        bodyParametersForRegistration.put("name", changedName);
        list = listService.updateList(listID, bodyParametersForRegistration);

        la.verifyListName(list, changedName);
    }
}
