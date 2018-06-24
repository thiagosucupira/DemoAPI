package com.sucupira.courriers.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sucupira.courrier.CourrierApp;
import com.sucupira.courrier.model.Courrier;
import com.sucupira.courrier.repository.CourrierRepo;

/**
 * The Class CourrierAppTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CourrierApp.class)
public class CourrierAppTests {

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {
	}
	
	/** The courrier repo. */
	@Autowired
	CourrierRepo courrierRepo;
	
	/**
	 * Test list all courriers.
	 */
	@Test
	public void testListAllCourriers() {
		List<Courrier> courriers = courrierRepo.findAll();
		assertEquals(8, courriers.size());
	}
	
	/**
	 * Test list all active courriers.
	 */
	@Test
	public void testListAllActiveCourriers() {
		List<Courrier> courriers = courrierRepo.findAll().parallelStream().filter(c -> c.isActive()).collect(Collectors.toList()); // Hello Java 8 :)
		assertEquals(6, courriers.size());
	}
	
	/**
	 * Test fetch courrier by id.
	 */
	@Test
	public void testFetchCourrierById() {
		Courrier courrier = courrierRepo.findOne(1L);
		assertEquals("skippity@giggity.com", courrier.getEmail());
	}
	
	/**
	 * Test add courrier.
	 */
	@Test
	public void testAddCourrier() {
		Courrier courrier = new Courrier(9L, "Potato Head Groove Thing", "potato@timhortons.gov.ca", 5, true);
		courrierRepo.save(courrier);
		assertEquals(8, courrierRepo.findAll().size());
	}
	
	/**
	 * Test update courrier.
	 */
	@Test
	public void testUpdateCourrier() {
		// TODO fetch the updated Courrier and compare the updated fields
	}
	
	/**
	 * Test delete courrier.
	 */
	@Test
	public void testDeleteCourrier() {
		Courrier courrier = new Courrier(9L, "Potato Head Groove Thing", "potato@timhortons.gov.ca", 5, true);
		courrierRepo.delete(courrier);
		assertEquals(8, courrierRepo.findAll().size());
	}
}
