package fr.mistral.demoenv;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(initializers = TestApplicationContextInitializer.class)
@SpringBootTest
class DemoEnvApplicationTests {

    @Test
    void contextLoads() {
    }

}
