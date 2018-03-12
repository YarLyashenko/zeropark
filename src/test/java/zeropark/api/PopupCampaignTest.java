package zeropark.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PopupCampaignTest extends BaseApiTest {

    @Test
    public void pauseActiveTargetAtPPVSourceCampaign() {

        String popupCampaignId = given()
                .spec(TOKEN_HEADER_SPEC)
                .param("interval", "THIS_YEAR")
                .when()
                .get("/stats/campaign/popup")
                .then()
                .statusCode(200)
                .body("elements", hasSize(greaterThan(0)))
                .extract()
                .path("elements.findAll{elements -> elements.details.name == 'PPV-Source'}.details.id[0]");

        String activeTargetHash = given()
                .spec(TOKEN_HEADER_SPEC)
                .param("interval", "THIS_YEAR")
                .pathParam("popupCampaignId", popupCampaignId)
                .when()
                .get("/stats/campaign/{popupCampaignId}/targets")
                .then().log().ifError()
                .statusCode(200)
                .body("elements", hasSize(greaterThan(0)))
                .extract()
                .path("elements.findAll{elements -> elements.state.state == 'ACTIVE'}.target[0]");

        given()
                .spec(TOKEN_HEADER_SPEC)
                .param("hash", activeTargetHash)
                .pathParam("popupCampaignId", popupCampaignId)
                .when()
                .post("/campaign/{popupCampaignId}/target/pause")
                .then()
                .statusCode(200)
                .body("state.state", equalTo("PAUSED"));
    }
}
