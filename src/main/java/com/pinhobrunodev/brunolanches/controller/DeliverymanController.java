package com.pinhobrunodev.brunolanches.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pinhobrunodev.brunolanches.dto.DeliverymanDTO;
import com.pinhobrunodev.brunolanches.services.DeliverymanService;



@RestController
@RequestMapping(value = "/deliverymans")
public class DeliverymanController {

	@Autowired
	private DeliverymanService service;
	
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliverymanDTO> insert(@RequestBody  DeliverymanDTO dto){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}
	@PutMapping(value = "/updated",consumes =  MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliverymanDTO> update(@RequestBody DeliverymanDTO dto){
		return ResponseEntity.ok().body(service.update(dto));
	}
	@DeleteMapping(value= "/{id}/removed",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value = "/{email}/found",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliverymanDTO>  findByEmail(@PathVariable String email){
		return ResponseEntity.ok().body(service.findByEmail(email));
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeliverymanDTO>> findAllOrderByNameASC(){
		return ResponseEntity.ok().body(service.findAllOrderByNameASC());
	}
}
