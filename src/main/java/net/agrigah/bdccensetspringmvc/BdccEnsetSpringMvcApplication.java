package net.agrigah.bdccensetspringmvc;
import net.agrigah.bdccensetspringmvc.entities.Product;
import net.agrigah.bdccensetspringmvc.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BdccEnsetSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(net.agrigah.bdccensetspringmvc.BdccEnsetSpringMvcApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "Ordinateur", 6500, 10));
			productRepository.save(new Product(null, "Imprimante", 1200, 5));
			productRepository.save(new Product(null, "Souris", 150, 25));
		};
	}
}