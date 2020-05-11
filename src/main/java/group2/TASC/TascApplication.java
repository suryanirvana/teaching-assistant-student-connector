package group2.TASC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.micrometer.core.aop.TimedAspect;

@SpringBootApplication
public class TascApplication {

	public static void main(String[] args) {
		SpringApplication.run(TascApplication.class, args);
	}

}
