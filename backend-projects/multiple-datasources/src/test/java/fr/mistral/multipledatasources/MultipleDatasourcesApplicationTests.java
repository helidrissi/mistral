package fr.mistral.multipledatasources;

import fr.mistral.multipledatasources.dao.product.ProductRepository;
import fr.mistral.multipledatasources.dao.user.UserRepository;
import fr.mistral.multipledatasources.domain.product.Product;
import fr.mistral.multipledatasources.domain.user.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class MultipleDatasourcesApplicationTests {


}
