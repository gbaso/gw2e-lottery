package com.github.gbaso.gw2elottery.enterer;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.With;

@Builder
@Document
record LotteryLog(
        @Id
        String id,
        @Version
        int version,
        String accountName,
        String giveawayId,
        @With
        String status,
        @With
        String error,
        @Indexed
        Instant timestamp
) {

    static LotteryLog of(String accountName, String giveawayId) {
        return LotteryLog.builder()
                .accountName(accountName)
                .giveawayId(giveawayId)
                .timestamp(Instant.now())
                .build();
    }

}
