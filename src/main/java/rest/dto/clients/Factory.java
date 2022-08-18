package rest.dto.clients;

import com.github.javafaker.Faker;
import rest.dto.clients.getAllModals.AllProjects;
import rest.dto.clients.getModals.*;
import rest.dto.clients.postModals.Project;
import rest.dto.clients.postModals.ResponseEndpointPost;

import java.util.List;

public class Factory {

    Faker faker = new Faker();
    String title = faker.name().title();
    String code = "dsfgs";
    public Project prepareObject() {
        return Project.builder()
                      .title(title)
                      .code("dsfgs")
                      .description(faker.rickAndMorty().quote())
                      .access("all")
                      .group(faker.name().name())
                      .build();
    }

    public ResponseEndpointPost preparePostResponse() {
        return ResponseEndpointPost.builder()
                                   .status(true)
                                   .result(Project.builder()
                                                  .code("DSFGS").build()).build();
    }

    public ResponseEndpointGet prepareGetResponse() {
        return ResponseEndpointGet.builder()
                                  .status(true)
                                  .result(Result.builder()
                                                .title(title)
                                                .code("DSFGS")
                                                .counts(Counts.builder()
                                                              .cases(0)
                                                              .suites(0)
                                                              .milestones(0)
                                                              .runs(Runs.builder()
                                                                        .total(0)
                                                                        .active(0).build())
                                                              .defects(Defects.builder()
                                                                              .total(0)
                                                                              .open(0).build()).build()).build()).build();
    }

    public AllProjects prepareGetAllProjectsResponse() {
        return AllProjects.builder()
                          .status(true)
                          .result(rest.dto.clients.getAllModals.Result.builder()
                                                                      .total(2)
                                                                      .filtered(2)
                                                                      .count(0)
                                                                      .entities(List.of()).build()).build();
    }
}
