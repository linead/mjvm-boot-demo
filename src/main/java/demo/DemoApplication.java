package demo;

import demo.model.Meetup;
import demo.model.MeetupRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public InitializingBean createTestData(MeetupRepository r) {
        return () -> {
            r.save(new Meetup(1l, "An exciting meetup"));
            r.save(new Meetup(2l, "Another exciting meetup"));
            r.flush();

            r.findAll().forEach(System.err::println);
        };
    }
}
