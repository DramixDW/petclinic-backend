package be.heh.petclinic.web;

import be.heh.petclinic.PetClinicApplication;
import be.heh.petclinic.component.vet.VetComponent;
import be.heh.petclinic.domain.Vet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	public ResponseEntity<Collection<Vet>> getVets(){
		System.out.println("lol");
		Collection<Vet> vets = vetComponentImpl.getVets();
		if(vets.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(vets, HttpStatus.OK);
	}

	@RequestMapping("vet")
	public ResponseEntity<Vet> getVet(@RequestParam(value="name") String name){
		Vet vet = vetComponentImpl.getVet(name);
		if(vet == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(vet,HttpStatus.OK);
	}
}