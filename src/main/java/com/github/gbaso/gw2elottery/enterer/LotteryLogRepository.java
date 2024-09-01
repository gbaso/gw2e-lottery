package com.github.gbaso.gw2elottery.enterer;

import org.springframework.data.mongodb.repository.MongoRepository;

interface LotteryLogRepository extends MongoRepository<LotteryLog, String> {}
