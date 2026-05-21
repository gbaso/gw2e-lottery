package com.github.gbaso.gw2elottery.giveaway;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    String enter(@RequestBody EnterGiveawayRequest request) {
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
    String enterCurrent(@RequestBody EnterCurrentGiveawayRequest request) {
        return giveawayService.enterCurrent(request.name());
    }

    record EnterCurrentGiveawayRequest(String name) {}

    record EnterGiveawayRequest(String name, String giveawayId) {}

}
