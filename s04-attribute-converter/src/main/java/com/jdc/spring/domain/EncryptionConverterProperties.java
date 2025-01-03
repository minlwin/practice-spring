package com.jdc.spring.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app.entity.attribute")
public class EncryptionConverterProperties {

	private String secretKey;
	private String algorithm;
}
