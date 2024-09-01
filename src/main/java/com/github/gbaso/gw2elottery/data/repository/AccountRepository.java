package com.github.gbaso.gw2elottery.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.gbaso.gw2elottery.data.entity.Account;

public interface AccountRepository extends MongoRepository<Account, String> {}
