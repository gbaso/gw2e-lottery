package com.github.gbaso.gw2elottery.service;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

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

    public List<Giveaway> list() throws IOException {
        try (var response = client.get("giveaways/list", Map.of())) {
            var type = mapper.getTypeFactory().constructCollectionType(List.class, Giveaway.class);
            return mapper.readValue(response.body().byteStream(), type);
        }
    }

    public Giveaway current() throws IOException {
        List<Giveaway> giveaways = list();
        return giveaways.stream()
                .filter(it -> between(Instant.now(), it.startsAt(), it.endsAt()))
                .findAny()
                .or(() -> giveaways.stream().findFirst())
                .orElseThrow();
    }

    public List<Partecipation> partecipation(String name) throws IOException {
        try (var response = client.get("giveaways/participation", Map.of("name", name))) {
            var type = mapper.getTypeFactory().constructCollectionType(List.class, Partecipation.class);
            return mapper.readValue(response.body().byteStream(), type);
        }
    }

    public boolean enteredCurrent(String name) throws IOException {
        var current = current();
        return entered(name, current.id());
    }

    public boolean entered(String name, String giveawayId) throws IOException {
        List<Partecipation> partecipations = partecipation(name);
        return partecipations.stream().anyMatch(it -> it.giveawayId().equals(giveawayId));
    }

    public String enter(String name, String giveawayId) throws IOException {
        try (var response = client.get("giveaways/enter", Map.of("name", name, "giveaway_id", giveawayId))) {
            JsonNode json = mapper.readTree(response.body().byteStream());
            return json.get("status").asText();
        }
    }

    private boolean between(Instant now, Instant startsAt, Instant endsAt) {
        return now.isAfter(startsAt) && now.isBefore(endsAt);
    }

}
