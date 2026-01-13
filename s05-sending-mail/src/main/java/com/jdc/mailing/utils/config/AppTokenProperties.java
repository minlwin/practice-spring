package com.jdc.mailing.utils.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "app.token")
public class AppTokenProperties {

	private String prefix;
}
