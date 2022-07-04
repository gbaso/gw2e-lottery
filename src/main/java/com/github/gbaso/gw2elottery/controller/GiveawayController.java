package com.github.gbaso.gw2elottery.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class GiveawayController {

    private final GiveawayService giveawayService;

    @GetMapping
    public List<Giveaway> giveaways() throws IOException {
        return giveawayService.list();
    }

    @GetMapping("/current")
    public Giveaway current() throws IOException {
        return giveawayService.current();
    }

    @GetMapping("/partecipation")
    public List<Partecipation> partecipation(@RequestParam String name) throws IOException {
        return giveawayService.partecipation(name);
    }

    @GetMapping("/current/entered")
    public boolean entered(@RequestParam String name) throws IOException {
        return giveawayService.enteredCurrent(name);
    }

    @PostMapping("/current/enter")
    public String enter(String name, String giveawayId) throws IOException {
        return giveawayService.enter(name, giveawayId);
    }

}
