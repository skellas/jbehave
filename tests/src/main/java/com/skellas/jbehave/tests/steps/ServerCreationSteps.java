package com.skellas.jbehave.tests.steps;

import com.skellas.jbehave.domain.Server;
import com.skellas.jbehave.domain.ServerStatus;
import com.skellas.jbehave.tests.domain.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@Steps
public class ServerCreationSteps {
    private Server server;

    @Given("a server is created with identifier <identifier> and status <status>")
    public void createServerWithPrescribedParameters(
            @Named("identifier") String identifier,
            @Named("status")ServerStatus status) {
        System.out.println("Creating a new Server(" + status + ", " + identifier + ")");
        server = new Server(status, identifier);
    }

    @Then("the server responds with <knownIdentifier>")
    public void serverShouldRespondWithKnownIdentifier(@Named("knownIdentifier") String knownIdentifier) {
        System.out.println("Server has identifier of : " + server.getIdentifier());
        assertEquals("Values should be the same.", knownIdentifier, server.getIdentifier());
    }

    @Then("the server responds with <knownStatus>")
    public void serverShouldRespondWithKnownStatus(@Named("knownStatus") String knownStatus) {
        System.out.println("Server has status of : " + server.getStatus());
        assertEquals("Values should be the same.", knownStatus.toString(), server.getStatus().toString());
    }
}
