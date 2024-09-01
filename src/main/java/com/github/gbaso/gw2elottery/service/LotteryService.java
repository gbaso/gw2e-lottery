package com.github.gbaso.gw2elottery.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.gbaso.gw2elottery.data.entity.Account;
import com.github.gbaso.gw2elottery.data.entity.LotteryLog;
import com.github.gbaso.gw2elottery.data.repository.AccountRepository;
import com.github.gbaso.gw2elottery.data.repository.LotteryLogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LotteryService {

    private final AccountRepository accountRepository;
    private final LotteryLogRepository lotteryLogRepository;
    private final GiveawayService giveawayService;

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.DAYS)
    public void enterGiveaway() throws IOException {
        String currentGiveawayId = giveawayService.current().id();
        List<Account> accounts = accountRepository.findAll();
        for (var account : accounts) {
            String accountName = account.name();
            if (!giveawayService.entered(accountName, currentGiveawayId)) {
                log.info("Entering account {} into giveaway {}", account.alias(), currentGiveawayId);
                enterGiveaway(currentGiveawayId, accountName);
            } else {
                log.debug("Skipping account {}, already entered", account.alias());
            }
        }
    }

    private void enterGiveaway(String currentGiveawayId, String accountName) throws IOException {
        var lotteryLog = lotteryLogRepository.save(LotteryLog.of(accountName, currentGiveawayId));
        try {
            String status = giveawayService.enter(accountName, currentGiveawayId);
            lotteryLogRepository.save(lotteryLog.withStatus(status));
        } catch (Exception e) {
            lotteryLogRepository.save(lotteryLog.withError(e.getMessage()));
            throw e;
        }
    }

}
