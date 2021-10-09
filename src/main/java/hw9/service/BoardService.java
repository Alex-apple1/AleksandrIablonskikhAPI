package hw9.service;

import com.google.gson.GsonBuilder;
import hw9.dto.BoardDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;


public class BoardService extends CommonService{

    public BoardDTO parseBoard(Response rs) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(rs.getBody().asString(), BoardDTO.class);
    }

    public BoardDTO createBoard(Map<String, String> parameters) {
        return parseBoard(requestWithParams(Method.POST, BOARDS_END_POINT, parameters));
    }

    public BoardDTO getBoard(String boardID) {
        return parseBoard(requestWithNoParams(Method.GET, BOARDS_END_POINT + boardID));
    }

    public BoardDTO updateBoard(Map<String, String> parameters, String boardID) {
        return parseBoard(requestWithParams(Method.PUT, BOARDS_END_POINT + boardID, parameters));
    }

    public Response deleteBoard(String boardID) {
        return requestWithNoParams(Method.DELETE, BOARDS_END_POINT + boardID);
    }
}
