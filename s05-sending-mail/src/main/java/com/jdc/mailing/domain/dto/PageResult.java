package com.jdc.mailing.domain.dto;

import java.util.List;

public record PageResult<T>(
		int page,
		int size,
		long total,
		List<T> contents) {
	
	public static <T> Builder<T> builder() {
		return new Builder<>();
	}

	public static class Builder<T> {
		private int page;
		private int size;
		private long total;
		private List<T> contents;

		public Builder<T> page(int page) {
			this.page = page;
			return this;
		}

		public Builder<T> size(int size) {
			this.size = size;
			return this;
		}

		public Builder<T> total(long total) {
			this.total = total;
			return this;
		}

		public Builder<T> contents(List<T> contents) {
			this.contents = contents;
			return this;
		}

		public PageResult<T> build() {
			return new PageResult<>(page, size, total, contents);
		}
	}
}
