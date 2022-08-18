package rest.dto.clients;

import io.restassured.response.Response;
import rest.dto.clients.getAllModals.AllProjects;
import rest.dto.clients.getModals.ResponseEndpointGet;
import rest.dto.clients.postModals.Project;
import rest.dto.clients.postModals.ResponseEndpointPost;

import java.util.Map;

public class ProjectApiClient extends BaseApiClient{

    public static final String PROJECT_URI = "/v1/project";
    public static final String PROJECT_URI_WITH_CODE = PROJECT_URI + "/{projectCode}";
    public static final String PROJECT_CODE = "projectCode";

    public ResponseEndpointPost postProject(Project project) {
        Response response = post(PROJECT_URI, project);
        return response.then()
                       .statusCode(200)
                       .extract()
                       .body()
                       .as(ResponseEndpointPost.class);
    }

    public ResponseEndpointGet getProject(String projectCode) {
        Response response = get(PROJECT_URI_WITH_CODE, Map.of(PROJECT_CODE, projectCode));
        return response.then()
                       .statusCode(200)
                       .extract()
                       .body()
                       .as(ResponseEndpointGet.class);
    }

    public AllProjects getAllProject(String projectCode) {
        Response response = get(PROJECT_URI_WITH_CODE, Map.of(PROJECT_CODE, projectCode));
        return response.then()
                       .statusCode(200)
                       .extract()
                       .body()
                       .as(AllProjects.class);
    }

    public Response getProjectResponse(String projectCode) {
        return get(PROJECT_URI_WITH_CODE, Map.of(PROJECT_CODE, projectCode));
    }

    public void deleteProject(String projectCode) {
        Response response = delete(PROJECT_URI_WITH_CODE, Map.of(PROJECT_CODE, projectCode));
        response.then()
                .statusCode(200);
    }
}
