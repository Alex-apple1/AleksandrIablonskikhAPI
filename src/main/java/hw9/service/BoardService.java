package hw9.service;

import com.google.gson.GsonBuilder;
import hw9.dto.BoardDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;


public class BoardService extends CommonService{

    public BoardDTO parseBoard(Response response) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(response.getBody().asString(), BoardDTO.class);
    }

    public BoardDTO createBoard(Map<String, String> parameters) {
        return parseBoard(getWithParams(Method.POST, BOARDS_END_POINT, parameters));
    }

    public BoardDTO getBoard(String boardID) {
        return parseBoard(getNoParams(Method.GET, BOARDS_END_POINT + boardID));
    }

    public BoardDTO updateBoard(Map<String, String> parameters, String boardID) {
        return parseBoard(getWithParams(Method.PUT, BOARDS_END_POINT + boardID, parameters));
    }

    public Response deleteBoard(String boardID) {
        return getNoParams(Method.DELETE, BOARDS_END_POINT + boardID);
    }
}
