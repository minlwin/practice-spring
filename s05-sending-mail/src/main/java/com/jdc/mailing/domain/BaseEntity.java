package com.jdc.mailing.domain;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	private Boolean deleted = false;
	
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String modifiedBy;
	@CreatedDate
	private Instant createdAt;
	@LastModifiedDate
	private Instant modifiedAt;
}
