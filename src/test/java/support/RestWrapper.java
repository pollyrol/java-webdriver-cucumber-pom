package support;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

import definitions.RestStepDefs;

public class RestWrapper {

    private String baseUrl = "https://skryabin.com/recruit/api/v1/";
    private String loginToken;

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public RestWrapper login(HashMap<String, String> credentials) throws UnirestException {
//        BaseRequest request = Unirest
//                .post(baseUrl + "login")
//                .header("Content-Type", "application/json")
//                .body(new JSONObject(credentials));

        HttpResponse<JsonNode> response = Unirest
                .post(baseUrl + "login")
                .header("Content-Type", "application/json")
                .body(new JSONObject(credentials))
                .asJson();

        assertThat(response.getStatus()).isEqualTo(200);
        JSONObject body = response.getBody().getObject();
        setLoginToken(body.getString("token"));
        System.out.println("Login successful! Token: " + getLoginToken());
        System.out.println("\n--------");
        return this;
    }

    public HttpResponse<JsonNode> getPositions (HashMap<String, String> values) throws UnirestException {

        HttpResponse<JsonNode> response = Unirest
                .get(baseUrl + "positions")
                .asJson();

//      --- assert correct response ---
//        assertThat(response.getStatus()).isEqualTo(200);
        assertEquals(200, response.getStatus());
        return response;

    }

    public RestWrapper postPosition(HashMap<String, String> values) throws UnirestException {

        HttpResponse<JsonNode> response = Unirest
                .post(baseUrl + "positions")
                .header("Content-Type", "application/json")
//                .header("x-access-token", getLoginToken())
                .header("x-access-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im93ZW5AZXhhbXBsZS5jb20iLCJpYXQiOjE1NjEwNTUwODAsImV4cCI6MTU2MTE0MTQ4MH0.6Ye9U2FYELLOVm2wnYnn0tRaNKw399S9yGDMm1Bp-HA")
                .body(new JSONObject(values))
                .asJson();

        assertEquals(201, response.getStatus());
//        assertThat(response.getStatus()).isEqualTo(201);

//        JSONObject body = response.getBody().getObject();
//        int positionId = body.getInt("id");
//        RestStepDefs positionId = new RestStepDefs();
//        positionId.setIdx(body.getInt("id"));
//        System.out.println("\n--------");
//        System.out.println("\npostPosition id: " + positionId.getIdx());
        return this;

    }

    public RestWrapper checkNewPosition (HashMap<String, String> values) throws UnirestException {

        JSONArray positionsList = getPositions(values).getBody().getArray();
        int lastIdx = positionsList.length() - 1;
        JSONObject newPosition = positionsList.getJSONObject(lastIdx);
//        int idx = newPosition.getInt("id");
        String title = newPosition.getString("title");
        String descr = newPosition.getString("description");

//        --- Assertions ---
        assertThat(title).contains(values.get("title"));
        assertThat(descr).contains(values.get("description"));


//        System.out.println("\n--------");
//        RestStepDefs positionId = new RestStepDefs();
//        System.out.println("\ncheckNewPosition id: " + positionId.getIdx());
//        System.out.println("\nTitle: " + title);
//        System.out.println("\nDescription: " + descr);
//        System.out.println("--------");
        return this;
    }

    public RestWrapper putPosition(HashMap<String, String> values) throws UnirestException {

        JSONObject position = new JSONObject(values);
        position.put("title", "Software Development/QA Automation Engineer");
//        System.out.println(position.getString("description"));

        HttpResponse<JsonNode> response = Unirest
                .put(baseUrl + "positions/82")
                .header("Content-Type", "application/json")
                .header("x-access-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im93ZW5AZXhhbXBsZS5jb20iLCJpYXQiOjE1NjEwNTUwODAsImV4cCI6MTU2MTE0MTQ4MH0.6Ye9U2FYELLOVm2wnYnn0tRaNKw399S9yGDMm1Bp-HA")
//                .header("x-access-token", getLoginToken())
                .body(new JSONObject(position))
                .asJson();

//        assertEquals(200, response.getStatus());
        assertThat(response.getStatus()).isEqualTo(200);

        JSONObject body = response.getBody().getObject();
//        int positionId = body.getInt("id");
//        RestStepDefs positionId = new RestStepDefs();
//        positionId.setIdx(body.getInt("id"));
        System.out.println("\n--------");
        System.out.println("\npostPosition id: " + body.getInt("id"));
        System.out.println("\ntitle: " + body.getString("title"));
        return this;

    }

    public RestWrapper deletePosition(int idx) throws UnirestException {

        HttpResponse<JsonNode> response = Unirest
                .delete(baseUrl + "positions/" + idx + "")
                .header("Content-Type", "application/json")
                .header("x-access-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im93ZW5AZXhhbXBsZS5jb20iLCJpYXQiOjE1NjEwNTUwODAsImV4cCI6MTU2MTE0MTQ4MH0.6Ye9U2FYELLOVm2wnYnn0tRaNKw399S9yGDMm1Bp-HA")
//                .header("x-access-token", getLoginToken())
//                .asJson();

        assertEquals(204, response.getStatus());
//        assertThat(response.getStatus()).isEqualTo(204);
        return this;
    }

}
