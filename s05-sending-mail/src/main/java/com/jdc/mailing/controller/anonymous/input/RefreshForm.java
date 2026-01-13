package com.jdc.mailing.controller.anonymous.input;

import jakarta.validation.constraints.NotBlank;

public record RefreshForm(
		@NotBlank(message = "Please provide refresh token.")
		String token) {

}
