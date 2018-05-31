package com.skellas.jbehave.domain;

public class Server {
    private ServerStatus status;
    private String identifier;

    public Server(ServerStatus status, String identifier) {
        this.status = status;
        this.identifier = identifier;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Server takeDown() {
        this.status = ServerStatus.DOWN;
        return this;
    }

    public Server startUp() {
        this.status = ServerStatus.AVAILABLE;
        return this;
    }
}
