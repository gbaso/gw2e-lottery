package com.github.gbaso.gw2elottery;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.mongodb.MongoDBContainer;

public interface MongoDBContainers {

    @Container
    @ServiceConnection
    MongoDBContainer mongo = new MongoDBContainer("mongo:latest");

}
