package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SampleController {
	@Autowired
	private SampleRepo sr;
	@PostMapping("/sample")
	public ResponseEntity<Sample>savedata(@RequestBody Sample sample){
		return new ResponseEntity<>(sr.save(sample),HttpStatus.CREATED);
		
	}
	@GetMapping("/sample")
	public ResponseEntity<List<Sample>>getdata(){
		return new ResponseEntity<>(sr.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/api/sample/{id}")
	public ResponseEntity<Sample>singledata(@PathVariable int id){
		Optional<Sample>op=sr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
			
		}
		else{
			return new ResponseEntity<>(HttpStatus.OK);
		}
			
		}
		@PutMapping("/api/sample/id")
		public ResponseEntity<Sample>putdata(@PathVariable int id,@RequestBody Sample demo){
			Optional<Sample>op = sr.findById(id);
			if(op.isPresent()) {
				op.get().setName(demo.getName());
				
				return new ResponseEntity<>(sr.save(op.get()),HttpStatus.OK);
				
			}
			else {
				return new ResponseEntity<>(HttpStatus.OK);
				
			}
			
		}
	@DeleteMapping("/api/sample/{id}")
	public ResponseEntity<Sample>delete(@PathVariable int id){
		Optional<Sample>op=sr.findById(id);
		if(op.isPresent()) {
			sr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}

		
	}
	
	

}
