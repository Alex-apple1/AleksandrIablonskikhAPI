package hw9.service;

import com.google.gson.GsonBuilder;
import hw9.entities.ListDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class ListService extends CommonService{

    public ListDTO parseList(Response response) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(response.getBody().asString(), ListDTO.class);
    }

    public ListDTO createList(Map<String, String> parameters) {
        return parseList(requestWithParams(Method.POST, LISTS_END_POINT, parameters));
    }

    public ListDTO updateList(String listID, Map<String, String> params) {
        return parseList(requestWithParams(Method.PUT, LISTS_END_POINT + listID, params));
    }
}
