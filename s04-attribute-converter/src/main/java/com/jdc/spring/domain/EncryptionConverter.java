package com.jdc.spring.domain;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
@Component
public class EncryptionConverter implements AttributeConverter<String, String>{
	
	private SecretKey secretKey;
	private Cipher cipher;
	
	public EncryptionConverter(EncryptionConverterProperties props) {
		try {
			this.secretKey = new SecretKeySpec(props.getSecretKey().getBytes(), props.getAlgorithm());
			this.cipher = Cipher.getInstance(props.getAlgorithm());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String convertToDatabaseColumn(String attribute) {
		
		if(StringUtils.hasLength(attribute)) {
			try {
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				var encryptedBytes = cipher.doFinal(attribute.getBytes());
				return Base64.getEncoder().encodeToString(encryptedBytes);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		
		if(StringUtils.hasLength(dbData)) {
			try {
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				var decodedBytes = Base64.getDecoder().decode(dbData);
				var decryptedBytes = cipher.doFinal(decodedBytes);
				return new String(decryptedBytes);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
