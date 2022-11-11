package com.ollcargo.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PocApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "CREATE TABLE IF NOT EXISTS orders (\n"
				+ "	id int PRIMARY KEY,\n"
				+ "	delivery_amount float(5),\n"
				+ "	client_amount float(5)\n"
				+ ")";
		jdbcTemplate.update(sql);
	}

	
}
