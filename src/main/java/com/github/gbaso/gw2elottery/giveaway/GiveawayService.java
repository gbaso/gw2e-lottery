package com.github.gbaso.gw2elottery.giveaway;

import com.github.gbaso.gw2elottery.client.Gw2EfficiencyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GiveawayService {

    private final Gw2EfficiencyClient client;
    private final JsonMapper mapper;

    List<Giveaway> list() {
        return client
                .get("giveaways/list", Map.of())
                .requiredBody(new ParameterizedTypeReference<>() {});
    }

    Giveaway current() {
        List<Giveaway> giveaways = list();
        return giveaways.stream()
                .filter(it -> between(Instant.now(), it.startsAt(), it.endsAt()))
                .findAny()
                .or(() -> giveaways.stream().findFirst())
                .orElseThrow();
    }

    public String currentId() {
        return current().id();
    }

    List<Partecipation> participation(String name) {
        return client
                .get("giveaways/participation", Map.of("name", name))
                .requiredBody(new ParameterizedTypeReference<>() {});
    }

    boolean enteredCurrent(String name) {
        Giveaway current = current();
        return entered(name, current.id());
    }

    public boolean entered(String name, String giveawayId) {
        List<Partecipation> participations = participation(name);
        return participations.stream().anyMatch(it -> it.giveawayId().equals(giveawayId));
    }

    String enterCurrent(String name) {
        Giveaway current = current();
        return enter(name, current.id());
    }

    public String enter(String name, String giveawayId) {
        String content = client
                .get("giveaways/enter", Map.of("name", name, "giveaway_id", giveawayId))
                .body(String.class);
        JsonNode json = mapper.readTree(content);
        return json.get("status").asString();
    }

    private boolean between(Instant now, Instant startsAt, Instant endsAt) {
        return now.isAfter(startsAt) && now.isBefore(endsAt);
    }

}
