package be.heh.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ImportResource(
        {
                "file:/home/dramixdw/Desktop/Cours/ProjetClinic/petcbackend/petclinic-core/src/be/heh/petclinic/component/component.xml",
                "file:/home/dramixdw/Desktop/Cours/ProjetClinic/petcbackend/petclinic-core/src/be/heh/petclinic/config.xml"}
                )

public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}
}