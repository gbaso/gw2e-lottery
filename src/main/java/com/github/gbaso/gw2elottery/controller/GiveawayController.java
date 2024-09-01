package com.github.gbaso.gw2elottery.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.gbaso.gw2elottery.data.dto.Giveaway;
import com.github.gbaso.gw2elottery.data.dto.Partecipation;
import com.github.gbaso.gw2elottery.service.GiveawayService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/giveaways")
class GiveawayController {

    private final GiveawayService giveawayService;

    @GetMapping
    List<Giveaway> giveaways() {
        return giveawayService.list();
    }

    @GetMapping("/participation")
    List<Partecipation> participation(@RequestParam String name) {
        return giveawayService.participation(name);
    }

    @PostMapping("/entered")
    boolean entered(@RequestBody EnterGiveawayRequest request) {
        return giveawayService.entered(request.name(), request.giveawayId());
    }

    @PostMapping("/enter")
    String enter(@RequestBody EnterGiveawayRequest request) throws IOException {
        return giveawayService.enter(request.name(), request.giveawayId());
    }

    @GetMapping("/current")
    Giveaway current() {
        return giveawayService.current();
    }

    @GetMapping("/current/entered")
    boolean entered(@RequestParam String name) {
        return giveawayService.enteredCurrent(name);
    }

    @PostMapping("/current/enter")
    String enterCurrent(@RequestBody EnterCurrentGiveawayRequest request) throws IOException {
        return giveawayService.enterCurrent(request.name());
    }

    record EnterCurrentGiveawayRequest(String name) {}

    record EnterGiveawayRequest(String name, String giveawayId) {}

}
