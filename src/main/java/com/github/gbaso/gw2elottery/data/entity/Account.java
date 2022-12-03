package com.github.gbaso.gw2elottery.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import org.hibernate.annotations.NaturalId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Account extends BaseEntity {

    @NaturalId
    @Column(nullable = false)
    private String  name;

    @Column
    private String  alias;

    @Column(nullable = false)
    private boolean main;

}
