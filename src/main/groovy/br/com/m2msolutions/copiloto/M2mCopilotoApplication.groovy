package br.com.m2msolutions.copiloto

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class M2mCopilotoApplication {

	static void main(String[] args) {
		SpringApplication.run M2mCopilotoApplication, args
	}
}
