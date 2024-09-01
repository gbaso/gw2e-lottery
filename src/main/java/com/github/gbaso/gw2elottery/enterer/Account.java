package com.github.gbaso.gw2elottery.enterer;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
record Account(
        @Id
        String id,
        @Version
        int version,
        @Indexed(unique = true)
        String name,
        String alias,
        boolean main
) {}
