package com.github.gbaso.gw2elottery.data.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.gbaso.gw2elottery.data.entity.Account;
import com.github.gbaso.gw2elottery.data.entity.QAccount;
import com.querydsl.core.types.Predicate;

@DataJpaTest
@Transactional
class AccountRepositoryTests {

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        var uno = Account.builder().name("uno").build();
        var due = Account.builder().name("due").build();
        var tre = Account.builder().name("tre").build();
        var quattro = Account.builder().name("quattro").build();
        accountRepository.saveAll(List.of(uno, due, tre, quattro));
    }

    @Test
    void findAll() {
        assertThat(accountRepository.findAll()).hasSize(4);
    }

    @Test
    void findByUsernameMaxLength() {
        var account = QAccount.account;
        Predicate predicate = account.name.length().loe(3);
        assertThat(accountRepository.findAll(predicate)).hasSize(3);
    }

}
