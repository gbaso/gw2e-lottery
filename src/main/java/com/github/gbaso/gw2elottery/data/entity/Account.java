package com.github.gbaso.gw2elottery.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Account(
        @Id
        String id,
        @Version
        int version,
        String name,
        String alias,
        boolean main
) {}
