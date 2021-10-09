package hw9.service;

import hw9.utils.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class CommonService extends URI {

    public RequestSpecification requestSpecification() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return new RequestSpecBuilder()
            .setBaseUri(URI)
            .setContentType(ContentType.JSON)
            .addQueryParam("key", PropertiesReader.getProperty("apiKey"))
            .addQueryParam("token", PropertiesReader.getProperty("apiToken"))
            .addFilter(new ResponseLoggingFilter())
            .build();
    }

    public Response getNoParams(Method method, String path) {

        return given()
            .spec(requestSpecification())
            .when()
            .request(method, path)
            .then()
            .statusCode(Matchers.greaterThanOrEqualTo(SC_OK))
            .extract()
            .response();
    }

    public Response getWithParams(Method method, String path, Map<String, String> parameters) {

        return given()
            .spec(requestSpecification())
            .queryParams(parameters)
            .when()
            .request(method, path)
            .then()
            .statusCode(Matchers.greaterThanOrEqualTo(SC_OK))
            .extract()
            .response();
    }
}
