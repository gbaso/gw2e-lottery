package com.github.gbaso.gw2elottery.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.gbaso.gw2elottery.data.entity.Account;
import com.github.gbaso.gw2elottery.data.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LotteryService {

    private final AccountRepository accountRepository;
    private final GiveawayService   giveawayService;

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.DAYS)
    public void enterGiveaway() throws IOException {
        String currentGiveawayId = giveawayService.current().id();
        List<Account> accounts = accountRepository.findAll();
        for (var account : accounts) {
            if (!giveawayService.entered(account.getName(), currentGiveawayId)) {
                log.info("Entering account {} into current giveaway", account.getAlias());
                giveawayService.enter(account.getName(), currentGiveawayId);
            } else {
                log.debug("Skipping account {}, already entered", account.getAlias());
            }
        }
    }

}
