package com.github.gbaso.gw2elottery;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

public interface MongoDBContainers {

    @Container
    @ServiceConnection
    MongoDBContainer mongo = new MongoDBContainer("mongo:latest");

}
