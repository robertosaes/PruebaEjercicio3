package com.bytesw.prueba.ejercicio3.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationConfiguration {

	@Bean
	public ExecutorService requestExecutorService() {
		return Executors.newWorkStealingPool();
	}

}
