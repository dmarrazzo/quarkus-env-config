package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class EnvResourceTest {

    @Test
    public void testEnvEndpoint() {
        given()
          .when().get("/env")
          .then()
             .statusCode(200);
    }

}