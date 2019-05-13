package com.thalles.teste.stock.common.commonservice.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senha = "teste@123";
		
		String encoded = encoder.encode(senha);
		System.out.println(encoded);
		
	}

}
