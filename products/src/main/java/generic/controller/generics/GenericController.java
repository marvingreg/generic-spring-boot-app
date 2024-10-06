package generic.controller.generics;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import generic.model.generics.GenericModel;
import generic.services.generics.GenericService;

public abstract class GenericController<T extends GenericModel<T>> {
	
	private final GenericService<T> service;
	
	public GenericController(GenericService<T> service) {
		this.service = service;
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getPage(Pageable pageable){
		try {
			return new ResponseEntity<Object>(service.getPage(pageable), HttpStatus.OK);
		}catch(NullPointerException e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.NOT_FOUND.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
			
		}catch(Exception e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.get(id), HttpStatus.OK);
		}catch(NullPointerException e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.NOT_FOUND.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
			
		}catch(Exception e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> create(T object){
		try {
			return new ResponseEntity<Object>(service.create(object), HttpStatus.OK);
		}catch(Exception e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("")
	public ResponseEntity<Object> update(T object){
		try {
			return new ResponseEntity<Object>(service.update(object), HttpStatus.OK);
		}catch(NullPointerException e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.NOT_FOUND.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
			
		}catch(Exception e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("")
	public ResponseEntity<Object> delete(Long id){
		try {
			return new ResponseEntity<Object>(service.delete(id), HttpStatus.OK);
		}catch(NullPointerException e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.NOT_FOUND.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
			
		}catch(Exception e) {
			Map<String, String> err = new HashMap<>();
			err.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
			err.put("message", e.getMessage());
			
			return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
