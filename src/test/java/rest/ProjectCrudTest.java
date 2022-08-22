package rest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import rest.dto.clients.Factory;
import rest.dto.clients.getAllModals.AllProjects;
import rest.dto.clients.getModals.*;
import rest.dto.clients.postModals.Project;
import rest.dto.clients.ProjectApiClient;
import rest.dto.clients.postModals.ResponseEndpointPost;

import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProjectCrudTest {

    ProjectApiClient projectApiClient = new ProjectApiClient();
    Factory factory = new Factory();

    @Test
    public void createPetTest() {
        Project expectedProject = factory.prepareObject();
        ResponseEndpointPost expectedResponseEndpointPost = factory.preparePostResponse();

        ResponseEndpointPost posProjectActual = projectApiClient.postProject(expectedProject);
        assertThat(posProjectActual).isEqualTo(expectedResponseEndpointPost);

        ResponseEndpointGet expectedResponseEndpointGet = factory.prepareGetResponse();
        ResponseEndpointGet getActualProject = projectApiClient.getProject("DSFGS");
        assertThat(getActualProject).isEqualTo(expectedResponseEndpointGet);
    }


    @Test
    public void deleteProjectTest() {
        Project expectedProject = factory.prepareObject();
        ResponseEndpointPost posProjectActual = projectApiClient.postProject(expectedProject);

        projectApiClient.deleteProject("DSFGS");

        Response deletedProjectResponse = projectApiClient.getProjectResponse("DSFGS");
        assertThat(deletedProjectResponse.statusCode()).as("Status code is incorrect in case for request for deleted project")
                                                       .isEqualTo(404);
        assertThat(deletedProjectResponse.body().jsonPath().getString("errorMessage")).as("Error message is incorrect")
                                                                                      .isEqualTo("Project is not found.");
    }

    @Test
    public void getAllProjectTest() {
        AllProjects expectedResponseEndpointGetAll = factory.prepareGetAllProjectsResponse();

        AllProjects actualResponseEndpointGetAll = projectApiClient.getAllProject();
        assertThat(actualResponseEndpointGetAll).isEqualTo(expectedResponseEndpointGetAll);
    }

    @Test
    public void validateGetProjectResponseAgainstSchemaTest() {
        Project expectedProject = factory.prepareObject();
        ResponseEndpointPost posProjectActual = projectApiClient.postProject(expectedProject);

        Response projectResponse = projectApiClient.getProjectResponse("DSFGS");
        projectResponse.then().assertThat().body(matchesJsonSchemaInClasspath("project-schema.json"));
    }
}