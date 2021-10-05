package hw9.service;

import hw9.utils.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class CommonService {
    protected static String URI = "https://trello.com";
    protected static String BOARDS_END_POINT = "/1/boards/";
    protected static String LISTS_END_POINT = "/1/lists/";

//    private RequestSpecification REQUEST_SPECIFICATION;

    public RequestSpecification requestSpecification() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return new RequestSpecBuilder()
            .setBaseUri(URI)
            .setContentType(ContentType.JSON)
            .addQueryParam("key", PropertiesReader.getProperty("apiKey"))
            .addQueryParam("token", PropertiesReader.getProperty("apiToken"))
            .build();
    }

    public Response requestWithNoParams(Method method, String path) {
        return
            given()
                .spec(requestSpecification())
                .when()
                .request(method, path)
                .then()
                .statusCode(SC_OK)
                .extract()
                .response();
    }

//    public CommonService() {
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//        REQUEST_SPECIFICATION = new RequestSpecBuilder()
//            .setBaseUri("https://trello.com/1/")
//            //.setBaseUri(ServiceProps.getBaseUrl())
//
//            // .setBaseUri(getProperties().getProperty("baseurl"))
//            .addHeader("key", PropertiesReader.getProperty("apiKey"))
//            .addHeader("token", PropertiesReader.getProperty("apiToken"))
//            .addFilter(new RequestLoggingFilter())
//            //.addFilter(new ResponseLoggingFilter())
//            .build();
//    }

    public Response requestWithParams(Method method, String path, Map<String, String> parameters) {
        return
            given()
                .spec(requestSpecification())
                .queryParams(parameters)
                .when()
                .request(method, path)
                .then()
                .statusCode(SC_OK)
                .extract()
                .response();
    }

    //    private RequestSpecification REQUEST_SPECIFICATION;
    //
    //    @SneakyThrows
    //    private Properties getProperties() {
    //        Properties props = new Properties();
    //        String propFileName = "test.properties";
    //        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
    //        return props;
    //    }
    //
    //    public CommonService() {
    //        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    //        REQUEST_SPECIFICATION = new RequestSpecBuilder()
    //            .setBaseUri("https://trello.com/1/")
    //            //.setBaseUri(ServiceProps.getBaseUrl())
    //
    //            // .setBaseUri(getProperties().getProperty("baseurl"))
    //            .addHeader("X-RapidAPI-Host", "trello.com/1")
    //            .addHeader("X-RapidAPI-Key", getProperties().get("X-RapidAPI-Key").toString())
    //            .addFilter(new RequestLoggingFilter())
    //            //.addFilter(new ResponseLoggingFilter())
    //            .build();
    //    }
    //
    //    public Response getNoParams(String uri) {
    //        Response response = given(REQUEST_SPECIFICATION).get(uri);
    //        response.then()
    //                .statusCode(Matchers.lessThan(300))
    //                .statusCode(Matchers.greaterThanOrEqualTo(200));
    //        return response;
    //    }
    //
    //    public Response getWithParams(String uri, Map<String, Object> params) {
    //        RequestSpecification specification = given(REQUEST_SPECIFICATION);
    //
    //        for (Map.Entry<String, Object> param : params.entrySet())
    //            specification.param(param.getKey(), param.getValue());
    //
    //        return specification.get(uri);
    //    }
}
