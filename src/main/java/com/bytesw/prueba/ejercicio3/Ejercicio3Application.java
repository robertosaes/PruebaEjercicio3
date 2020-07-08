package com.bytesw.prueba.ejercicio3;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan
@EnableAsync
public class Ejercicio3Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Ejercicio3Application.class)
        .addCommandLineProperties(true).bannerMode(Mode.CONSOLE)
        .headless(true).registerShutdownHook(true).logStartupInfo(true)
        .web(WebApplicationType.SERVLET).run(args);
	}

}
