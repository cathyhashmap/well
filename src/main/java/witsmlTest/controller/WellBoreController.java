package witsmlTest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import witsmlTest.model.Well2;
import witsmlTest.model.WellBore;
import witsmlTest.service.WellBoreService;
import witsmlTest.service.WellService;

/*
 * mocked controller
 */
@Controller
@RequestMapping("wellbore")
public class WellBoreController {

	@Autowired
	private WellBoreService mywellservice;
	@GetMapping("/wellbore/{id}")
	public WellBore getFromStore(@PathVariable String id) {
		WellBore wb = new WellBore(id);
		return  mywellservice.getFromStore(id);//HTTP 200 response code
	}
	
	@PostMapping("/wellbore/{id}")
	public ResponseEntity<Void> addToStore(@PathVariable String id) {
		WellBore addwell=mywellservice.addToStore(id);
		if(addwell==null)
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").build().toUri();//buildAndExpand(course.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/wellbore/{id}")
	public ResponseEntity<WellBore> updateInStore(@PathVariable String id) {
		WellBore well=mywellservice.updateInStore("10",id); 
		return new ResponseEntity<WellBore>(well, HttpStatus.OK);//200
	}
	
	@DeleteMapping("/wellbore/{id}")
	public ResponseEntity<Void> deleteFromStore(@PathVariable String id) {
		mywellservice.deleteFromStore(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//code 204
	}	
}