package be.heh.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(
{
		"classpath:/components/component.xml",
		"classpath:/components/config.xml"
})

public class PetClinicApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}
}