package classifiedcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("classifiedcounter.services")
public class ClassifiedCounter {

	public static void main(String[] args) {
		SpringApplication.run(ClassifiedCounter.class, args);
	}
}