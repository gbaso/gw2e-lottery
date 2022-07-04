package com.github.gbaso.gw2elottery.data.dto;

import java.time.Instant;

import lombok.Value;

@Value
public class Partecipation {

    String giveawayId;
    Instant creationDate;

}
