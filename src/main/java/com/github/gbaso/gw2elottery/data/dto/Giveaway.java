package com.github.gbaso.gw2elottery.data.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class Giveaway {

    @JsonProperty("_id")
    String      id;
    String      group;
    Instant     startsAt;
    Instant     endsAt;
    List<Prize> prizes;
    int         prizepool;
    int         contestants;

    @Value
    public static class Prize {
        int id;
        int count;
    }

}
