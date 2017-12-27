package com.sanbhu.net.config;

import org.springframework.context.annotation.Bean;

import com.sanbhu.net.utils.AESEncryptDecrypt;

public class WebApplicationConfig {

	@Bean
	public AESEncryptDecrypt getAESEncryptDecrypt() {
		return new AESEncryptDecrypt();
	}
	
}
