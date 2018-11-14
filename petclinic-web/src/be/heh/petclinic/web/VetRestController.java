package be.heh.petclinic.web;

import be.heh.petclinic.component.vet.VetComponent;
import be.heh.petclinic.domain.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/")
public class VetRestController {
	@Autowired
	private VetComponent vetComponentImpl;

	@RequestMapping("vets")
	public ResponseEntity<Collection<Vet>> getVets() {
		Collection<Vet> vets = vetComponentImpl.getVets();
		return vets.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(vets, HttpStatus.OK);
	}

	@RequestMapping("vet")
	public ResponseEntity<Vet> getVet(@RequestParam(value="name") String name){
		Vet vet = vetComponentImpl.getVet(name);
		return vet == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(vet,HttpStatus.OK);
	}
}