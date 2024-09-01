package com.github.gbaso.gw2elottery.enterer;

import org.springframework.data.mongodb.repository.MongoRepository;

interface AccountRepository extends MongoRepository<Account, String> {}
