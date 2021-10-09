package hw9.service;

import com.google.gson.GsonBuilder;
import hw9.dto.ListDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class ListService extends CommonService {

    public ListDTO parseList(Response response) {

        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(response.getBody().asString(), ListDTO.class);
    }

    public ListDTO createList(Map<String, String> parameters) {

        return parseList(getWithParams(Method.POST, LISTS_END_POINT, parameters));
    }

    public ListDTO getList(String listID) {

        return parseList(getNoParams(Method.GET, LISTS_END_POINT + listID));
    }

    public ListDTO updateList(String listID, Map<String, String> params) {

        return parseList(getWithParams(Method.PUT, LISTS_END_POINT + listID, params));
    }

    public Response deleteList(String listID, Map<String, String> params) {

        return getNoParams(Method.DELETE, LISTS_END_POINT + listID);
    }
}
