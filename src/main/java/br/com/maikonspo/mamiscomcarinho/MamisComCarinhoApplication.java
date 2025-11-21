package br.com.maikonspo.mamiscomcarinho;

import br.com.maikonspo.mamiscomcarinho.config.AdminUserProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AdminUserProps.class)
public class MamisComCarinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MamisComCarinhoApplication.class, args);
	}

}
