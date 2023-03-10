package org.example.tests.base;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.actions.AssertActions;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;

   @BeforeMethod
    public void setUpConfig() {
        payloadManager = new PayloadManager();
        //requestSpecification =  RestAssured.given().baseUri(APIConstants.BASE_URI)
          //      .contentType("application/json");

   //using Rquestspecbuilder
       requestSpecification = (RequestSpecification) new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URI)
               .addHeader("Content-Type", "application/json").build().log().all();

   }



}
