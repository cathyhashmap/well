package witsmlTest.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import witsmlTest.model.Well2;
import witsmlTest.service.WellService;

/**
 * 
 * @author cathychen
 * This is mocked controller
 */
@RestController
@RequestMapping("well")
public class Well2Controller {

	@Autowired
	private WellService mywellservice;
	@GetMapping("/well/{compamy}")
	public Well2 getFromStore(@PathVariable String compamy) {
		Well2 well = new Well2(compamy);
		//return new ResponseEntity<Well2>(well, HttpStatus.OK);//HTTP 200 response code
		return mywellservice.getFromStore(compamy);
	}
	
	@PostMapping("/well/{compamy}")
	public ResponseEntity<Void> addToStore(@PathVariable String compamy)
	{
		Well2 addwell=mywellservice.addToStore(compamy);
		if(addwell==null)
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{compamy}").build().toUri();//buildAndExpand(course.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("well/{compamy}")
	public ResponseEntity<Well2> updateInStore(@PathVariable String compamy) {
		Well2 well=mywellservice.updateInStore("BHI",compamy); 
		return new ResponseEntity<Well2>(well, HttpStatus.OK);//200
	}
	
	@DeleteMapping("well{compamy}")
	public ResponseEntity<Void> deleteFromStore(@PathVariable String compamy) {
		mywellservice.deleteFromStore(compamy);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//code 204
	}		
}
