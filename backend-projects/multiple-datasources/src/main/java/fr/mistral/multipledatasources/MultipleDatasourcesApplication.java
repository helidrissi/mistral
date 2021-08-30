package fr.mistral.multipledatasources;

import fr.mistral.multipledatasources.dao.product.ProductRepository;
import fr.mistral.multipledatasources.dao.user.UserRepository;
import fr.mistral.multipledatasources.domain.product.Product;
import fr.mistral.multipledatasources.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class MultipleDatasourcesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatasourcesApplication.class, args);
    }


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("john@test.com");
        user1.setAge(20);
        userRepository.save(user1);

        Product product = new Product();
        product.setName("Book");
        product.setId(2);
        product.setPrice(20);
        productRepository.save(product);
    }
}
