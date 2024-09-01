package com.github.gbaso.gw2elottery.service;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gbaso.gw2elottery.data.dto.Giveaway;
import com.github.gbaso.gw2elottery.data.dto.Partecipation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GiveawayService {

    private final Gw2EfficiencyClient client;
    private final ObjectMapper mapper;

    public List<Giveaway> list() {
        return client
                .get("giveaways/list", Map.of())
                .body(new ParameterizedTypeReference<>() {});
    }

    public Giveaway current() {
        List<Giveaway> giveaways = list();
        return giveaways.stream()
                .filter(it -> between(Instant.now(), it.startsAt(), it.endsAt()))
                .findAny()
                .or(() -> giveaways.stream().findFirst())
                .orElseThrow();
    }

    public List<Partecipation> participation(String name) {
        return client
                .get("giveaways/participation", Map.of("name", name))
                .body(new ParameterizedTypeReference<>() {});
    }

    public boolean enteredCurrent(String name) {
        Giveaway current = current();
        return entered(name, current.id());
    }

    public boolean entered(String name, String giveawayId) {
        List<Partecipation> participations = participation(name);
        return participations.stream().anyMatch(it -> it.giveawayId().equals(giveawayId));
    }

    public String enter(String name, String giveawayId) throws IOException {
        String content = client
                .get("giveaways/enter", Map.of("name", name, "giveaway_id", giveawayId))
                .body(String.class);
        JsonNode json = mapper.readTree(content);
        return json.get("status").asText();
    }

    private boolean between(Instant now, Instant startsAt, Instant endsAt) {
        return now.isAfter(startsAt) && now.isBefore(endsAt);
    }

}
