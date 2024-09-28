package com.github.gbaso.gw2elottery.enterer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface AccountRepository extends MongoRepository<Account, String> {}
