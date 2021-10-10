package hw9.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hw9.dto.BoardDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class BoardService extends CommonService {

    public BoardDTO parseBoard(Response response) {

        return new GsonBuilder()
            .excludeFieldsWithModifiers()
            .create()
            .fromJson(response.getBody().asString(), BoardDTO.class);
    }

//    private BoardService boardService;
//
//    public BoardService getInstance() {
//        if (boardService == null)
//            boardService = new BoardService();
//
//        return boardService;
//    }
//
//    public static BoardDTO createBoard(String name) {
//        return BoardDTO
//            .builder()
//            .name(name)
//            .build();
//    }
//
//    public BoardDTO[] getBoardByID(String boardID) {
//        return
//            new CommonService()
//                .getNoParams(String.format(hw9.service.URI.BOARDS_END_POINT, boardID))
//                .getBody().as(BoardDTO[].class);
//    }
//
//    public BoardDTO[] getCountryByCode(String code) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("codes", code);
//
//        return
//            new Gson().fromJson(
//                new CommonService()
//                    .getWithParams(hw9.service.URI.BOARDS_END_POINT, params)
//                    .getBody().asString(), BoardDTO[].class);
//    }
//
//    public BoardDTO createBoard(Map<String, String> parameters) {
//
//        return parseBoard(getWithParams(BOARDS_END_POINT, parameters));
//    }
//
//    public BoardDTO getBoard(String boardID) {
//
//        return parseBoard(getNoParams(BOARDS_END_POINT + boardID));
//    }
//
//    public BoardDTO updateBoard(Map<String, String> parameters, String boardID) {
//
//        return parseBoard(getWithParams(BOARDS_END_POINT + boardID, parameters));
//    }
//
//    public Response deleteBoard(String boardID) {
//
//        return getNoParams(BOARDS_END_POINT + boardID);
//    }

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
