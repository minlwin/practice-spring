package com.jdc.mailing.domain.entity;

import jakarta.persistence.Column;

public record AccountProfileHistoryPk(
		@Column(nullable = false)
		Integer id,
		@Column(nullable = false)
		Integer version) {

}
