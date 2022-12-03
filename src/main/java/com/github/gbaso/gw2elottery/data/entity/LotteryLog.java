package com.github.gbaso.gw2elottery.data.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;

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
public class LotteryLog extends BaseEntity {

	@Column(nullable = false, updatable = false)
	private String accountName;

	@Column(nullable = false, updatable = false)
	private String giveawayId;

	private String status;

	@Column(length = 1000)
	private String error;

	@CreationTimestamp
	@Setter(value = AccessLevel.NONE)
	private Instant timestamp;

}
