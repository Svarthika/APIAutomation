package org.example.tests.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.actions.AssertActions;
import org.example.endpoints.APIConstants;
import org.example.tests.base.BaseTest;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {


    private static final Logger log = LogManager.getLogger(CreateBookingTest.class);    ;

    @Test
    @Owner("varthika")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Booking can be Created")
    public void testCreateBooking() throws JsonProcessingException {
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);

        Response response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        ValidatableResponse validatableResponse = response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        System.out.println("Booking Id :" + jsonPath.getString("bookingid"));
        validatableResponse.statusCode(200);
       // assertActions.verifyStatusCode(response);
        System.out.println(jsonPath.getString("booking.age"));
        AssertActions assertActions = new AssertActions();
        assertActions.verifyResponseBody(jsonPath.getString("booking.lastname"),"surthy", "First name matching" );
        assertActions.verifyResponseBody(jsonPath.getString("booking.firstname"),"Varthika", "First name matching" );

        log.error("TestDone");

    }


}
