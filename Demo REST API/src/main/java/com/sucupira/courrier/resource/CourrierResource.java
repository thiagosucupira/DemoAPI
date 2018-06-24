package com.sucupira.courrier.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sucupira.courrier.model.Courrier;
import com.sucupira.courrier.repository.CourrierRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ExampleProperty;

/**
 * The Class CourrierResource.
 */
@Api(value="API REST for CRUDing Courriers")
@RestController
@RequestMapping("/courrier")
public class CourrierResource {

	/** The courrier repo. */
	@Autowired
	private CourrierRepo courrierRepo;

	/**
	 * Fetch all courriers.
	 *
	 * @return the list
	 */
	@ApiOperation(value="Returns a list of all the courriers in the in-memory database")
	@GetMapping(path="/fetchAllCourriers")
	public List<Courrier> fetchAllCourriers() {
		return courrierRepo.findAll();
	}
	
	/**
	 * Fetch all active courriers, filtering done with lambda expression and a parallel stream.
	 *
	 * @return the list
	 */
	@ApiOperation(value="Returns a list of all ACTIVE courriers in the in-memory database")
	@GetMapping(path="/fetchAllActiveCourriers")
	public List<Courrier> fetchAllActiveCourriers() {
		return courrierRepo.findAll().parallelStream().filter(c -> c.isActive()).collect(Collectors.toList()); // Hello Java 8 :)
	}

	/**
	 * Fetch courrier by id.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@ApiOperation(value="Returns a single courrier by their ID")
	@GetMapping("/{id}")
	public ResponseEntity<Courrier> fetchCourrierById(@PathVariable Long id) {
		
		ResponseEntity<Courrier> response = ResponseEntity.notFound().build();
		Courrier courrier = courrierRepo.findOne(id);

		if (courrier != null) {
			response = ResponseEntity.ok(courrier);
		}

		return response;
	}

	/**
	 * Adds the courrier.
	 *
	 * @param courrier the courrier
	 * @return the courrier
	 */
	@ApiOperation(value="Inserts a courrier in the in-memory database")
	@PostMapping
	public Courrier addCourrier(@Valid @RequestBody Courrier courrier) {
		return courrierRepo.save(courrier);
	}
	
	/**
	 * Update courrier.
	 *
	 * @param id the id
	 * @param courrier the courrier
	 * @return the response entity
	 */
	@ApiOperation(value="Updates a courrier in the in-memory database")
	@PutMapping("/{id}")
	public ResponseEntity<Courrier> updateCourrier(@PathVariable Long id, 
			@Valid @RequestBody Courrier courrier) {
		
		ResponseEntity<Courrier> response = ResponseEntity.notFound().build();
		Courrier cour = courrierRepo.findOne(id);

		if (cour != null) {
			 response = ResponseEntity.ok(cour);
		}
		
		BeanUtils.copyProperties(courrier, cour, "id");
		cour = courrierRepo.save(cour);

		return response;
	}

	/**
	 * Delete courrier.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deletes a courrier in the in-memory database")
	public ResponseEntity<Void> deleteCourrier(@PathVariable Long id) {
		
		ResponseEntity<Void> response = ResponseEntity.noContent().build();
		Courrier courrier = courrierRepo.getOne(id);

		if (courrier == null) {
			response = ResponseEntity.notFound().build();
		} else {
			courrierRepo.delete(courrier);
		}
		
		return response;
	}
}