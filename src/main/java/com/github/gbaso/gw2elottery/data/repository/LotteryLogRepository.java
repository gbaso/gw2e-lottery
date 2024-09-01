package com.github.gbaso.gw2elottery.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.gbaso.gw2elottery.data.entity.LotteryLog;

public interface LotteryLogRepository extends MongoRepository<LotteryLog, String> {}
