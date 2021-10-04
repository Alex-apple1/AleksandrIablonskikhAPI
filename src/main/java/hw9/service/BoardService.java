package hw9.service;

import com.google.gson.GsonBuilder;
import hw9.entities.Board;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;


public class BoardService extends CommonService{

    public Board parseBoard(Response rs) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(rs.getBody().asString(), Board.class);
    }

    public Board createBoard(Map<String, String> params) {
        return parseBoard(requestWithParams(Method.POST, BOARDS, params));
    }

    public Response deleteBoard(String boardID) {
        return requestWithNoParams(Method.DELETE, BOARDS + boardID);
    }

    public Board getBoard(String boardID) {
        return parseBoard(requestWithNoParams(Method.GET, BOARDS + boardID));
    }

    public Board updateBoard(Map<String, String> params, String boardID) {
        return parseBoard(requestWithParams(Method.PUT, BOARDS + boardID, params));
    }
}
