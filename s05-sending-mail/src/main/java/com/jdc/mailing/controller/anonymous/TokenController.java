package com.jdc.mailing.controller.anonymous;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.mailing.controller.anonymous.input.RefreshForm;
import com.jdc.mailing.controller.anonymous.input.SignInForm;
import com.jdc.mailing.controller.anonymous.output.AuthResult;

@RestController
@RequestMapping("auth/token")
public class TokenController {

	@PostMapping("generate")
	AuthResult generate(@Validated @RequestBody SignInForm form) {
		return null;
	}
	
	@PostMapping("refresh")
	AuthResult refresh(@Validated @RequestBody RefreshForm form) {
		return null;
	}
}
