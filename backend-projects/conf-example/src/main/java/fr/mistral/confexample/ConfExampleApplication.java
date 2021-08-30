package fr.mistral.confexample;

import fr.mistral.confexample.examplebeans.FakeDataSource;
import fr.mistral.confexample.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConfExampleApplication {

    public static void main(String[] args) {


        ApplicationContext ctx = SpringApplication.run(ConfExampleApplication.class, args);


        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

        System.out.println(fakeDataSource.getUser());

        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUsername());
    }

}
