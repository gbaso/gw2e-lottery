package com.github.gbaso.gw2elottery.giveaway;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

record Giveaway(
        @JsonProperty("_id")
        String id,
        String group,
        Instant startsAt,
        Instant endsAt,
        List<Prize> prizes,
        int prizepool,
        int contestants) {

    record Prize(int id, int count) {}

}
