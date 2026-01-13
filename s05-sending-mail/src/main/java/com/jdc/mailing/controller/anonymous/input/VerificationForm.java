package com.jdc.mailing.controller.anonymous.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record VerificationForm(
		@NotBlank(message = "Email is required")
		@Email(message = "Invalid email format")
		String email,
		@NotBlank(message = "OTP is required")
		String otp) {
}
