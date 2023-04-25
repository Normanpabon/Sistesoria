package com.sistesoria.APIREST_SISTESORIA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

//@SpringBootApplication

//@SpringBootApplication(scanBasePackages={"com.sistesoria.*"} ,exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class, R2dbcAutoConfiguration.class})
@SpringBootApplication
public class ApiSIstesoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSIstesoriaApplication.class, args);
	}

}
