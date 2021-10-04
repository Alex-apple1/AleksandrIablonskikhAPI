package hw9.service;

import com.google.gson.GsonBuilder;
import hw9.entities.List;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;

public class ListService extends CommonService{

    public List parseList(Response rs) {
        return new GsonBuilder().excludeFieldsWithModifiers().create()
                                .fromJson(rs.getBody().asString(), List.class);
    }

    public List createList(Map<String, String> parameters) {
        return parseList(requestWithParams(Method.POST, LISTS, parameters));
    }

    public List updateList(String listID, Map<String, String> params) {
        return parseList(requestWithParams(Method.PUT, LISTS + listID, params));
    }
}
