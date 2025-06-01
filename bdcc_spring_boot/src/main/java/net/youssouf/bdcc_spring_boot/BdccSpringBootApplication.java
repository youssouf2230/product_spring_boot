package net.youssouf.bdcc_spring_boot;

import net.youssouf.bdcc_spring_boot.entities.Product;
import net.youssouf.bdcc_spring_boot.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class BdccSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdccSpringBootApplication.class, args);
	}
	@Bean
	public CommandLineRunner star(ProductRepository repository) {
		return args -> {
			repository.save(Product.builder()
					.name("LENOVO")
					.description("PC Meilleur Qualite 16GB RAM")
					.price(2700)
					.quantity(3)
					.build());
			repository.save(Product.builder()
					.name("ACCER")
					.description("PC Meilleur Qualite 8GB RAM 4 coeurs")
					.price(3000)
					.quantity(2)
					.build());
			repository.findAll().forEach(
					product -> {
						System.out.println(product.toString());
					}
			);
		};
	}

}
