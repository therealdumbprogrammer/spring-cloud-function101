package com.thecodealchemist.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class Function101Application {

	public static void main(String[] args) {
		SpringApplication.run(Function101Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			FunctionCatalog catalog = ctx.getBean(FunctionCatalog.class);
			Function<String, Integer> func = catalog.lookup("strLength");
			System.out.println(func.apply("Hello"));
			System.out.println("==============");

			Function<String, String> upperFunc = catalog.lookup("toUpperCase");
			System.out.println(upperFunc.apply("world!"));
		};
	}

	@Bean
	public Function<String, Integer> strLength() {
		return str -> str.length();
	}
}
