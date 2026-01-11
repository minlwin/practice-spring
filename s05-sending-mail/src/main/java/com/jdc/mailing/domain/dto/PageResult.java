package com.jdc.mailing.domain.dto;

public record PageResult<T>(
		int page,
		int size,
		long total,
		T[] contents) {

}
