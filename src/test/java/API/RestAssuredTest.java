package API;

import apiModels.Data;
import apiModels.PostRequestModel;
import apiModels.PostRequestModelNegative;
import apiModels.PostResponseModel;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LogListener;

import static com.google.common.base.Predicates.and;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

@Listeners(LogListener.class)
public class RestAssuredTest {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
    }


    @Test
    public void testGetAllOperationPositive() {
        given()
                .get("/api/v1/employees")
                .then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.employee_age", hasItems(61));

        given()
                .get("/api/v1/employees")
                .then()
                .assertThat()
                .header("Server", "cloudflare");
    }

    @Test
    public void testGetAllOperationNegative() {
        given()
                .get("api/v1/employees/null")
                .then()
                .statusCode(404)
                .assertThat()
                .body("message", equalTo("Error Occured! Page Not found, contact rstapi2example@gmail.com"));

    }

    @Test
    public void testGetIdOperationPositive() {
        given()
                .get("/api/v1/employee/1")
                .then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("data.employee_name", equalTo("Tiger Nixon"))
                .body("data.employee_salary", is(320800));

        given()
                .get("/api/v1/employee/1")
                .then()
                .assertThat()
                .header("CF-RAY", contains("ZRH"));
    }

    @Test
    public void testGetIdOperationNegative() {
                given()
                .get("/api/v1/employee/1")
                .then()
                .log().body()
                .assertThat()
                .body("Content-Encoding", not("gzip"));
        given()
                .get("/api/v1/employee/1")
                .then()
                .assertThat()
                .header("Referrer-Policy", isEmptyString());
    }


    @Test
    public void testPostNewEmployeeOperation(){
        PostRequestModel postRequestModelObject = new PostRequestModel("Kate","20000","30");
        PostResponseModel expectedResponseModelObject = new PostResponseModel("success", new Data("Kate","20000","30"), "Successfully! Record has been added.");

        PostResponseModel responseModelObject = given()
                .with()
                .contentType("application/json")
                .body(postRequestModelObject)
                .log().all()
                .when()
                .request("POST","/api/v1/create")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .as(PostResponseModel.class);
        assertEquals(responseModelObject, expectedResponseModelObject);
    }

    @Test
    public void testPostNewEmployeeOperationNegative(){
        PostRequestModelNegative postRequestModelObjectNegative = new PostRequestModelNegative("Kate","20000");
        PostResponseModel expectedResponseModelObject = new PostResponseModel("success", new Data("Kate","20000","30"), "Successfully! Record has been added.");

        PostResponseModel responseModelObject = given()
                .with()
                .contentType("application/json")
                .body(postRequestModelObjectNegative)
                .log().all()
                .when()
                .request("POST","/api/v1/create")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .as(PostResponseModel.class);
        assertEquals(responseModelObject, expectedResponseModelObject);
    }

    @Test
    public void testDeleteEmployeeOperation(){
        when()
                .request("DELETE","/api/v1/delete/3")
                .then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data", equalTo("2"))
                .body("message", equalTo("Successfully! Record has been deleted"));

    }

    @Test
    public void testDeleteEmployeeOperationNegative(){
        when()
                .request("DELETE","/api/v1/delete/3")
                .then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data", equalTo("999"));

    }


//    @Test(dependsOnMethods = {"postNewEmployeePositive"})
//    public void putEmployeePositive() {
//        PutEmployeeRequestModel putRequestEmployeeObject = new PutEmployeeRequestModel("Jessika", "50000", "25");
//        PutEmployeeResponseModel putResponseModelObject = new PutEmployeeResponseModel("success",
//                new Data("Jessika", "50000", "25"), "Successfully! Record has been updated.");
//
//        PutEmployeeResponseModel responseNewEmployeeObject = given()
//                .with()
//                .contentType("application/json")
//                .body(putRequestEmployeeObject)
//                .log().all()
//                .when()
//                .request("PUT", "/api/v1/update/21")
//                .then()
//                .log().body()
//                .statusCode(200)
//                .extract()
//                .as(PutEmployeeResponseModel.class);
//        assertEquals(responseNewEmployeeObject, putResponseModelObject);
//    }

}
