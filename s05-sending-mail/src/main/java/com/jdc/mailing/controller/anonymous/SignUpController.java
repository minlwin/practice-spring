package com.jdc.mailing.controller.anonymous;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.mailing.controller.anonymous.input.SignUpForm;
import com.jdc.mailing.controller.anonymous.input.VerificationForm;
import com.jdc.mailing.controller.anonymous.output.AuthResult;
import com.jdc.mailing.controller.anonymous.output.MessageResult;

@RestController
@RequestMapping("auth/signup")
public class SignUpController {

	@PostMapping("initiate")
	MessageResult initate(@Validated @RequestBody SignUpForm form) {
		return null;
	}
	
	@PostMapping("verified")
	AuthResult verified(@Validated @RequestBody VerificationForm form) {
		return null;
	}
}
