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
	
	/** The courrier repo for the in-memory mock database. */
	@Autowired
	CourrierRepo courrierRepo;
		
	/**
	 * Test list all active courriers.
	 */
	@Test
	public void testListAllActiveCourriers() {
		assertEquals(6, courrierRepo.findAll().parallelStream().filter(c -> c.isActive()).collect(Collectors.toList()).size());
	}
	
	/**
	 * Test list all courriers.
	 */
	@Test
	public void testListAllCourriers() {
		assertEquals(8, Arrays.asList(courrierRepo.findAll()).size());
	}

	/**
	 * Test fetch courrier by id.
	 */
	@Test
	public void testFetchCourrierById() {
		assertEquals("skippity@giggity.com", courrierRepo.findOne(1L).getEmail());
	}
	
	/**
	 * Test add courrier.
	 */
	@Test
	public void testAddCourrier() {
		courrierRepo.save(new Courrier(9L, "Potato Head Groove Thing", "potato@gmail.com", 5, true));
		assertEquals(8, courrierRepo.findAll().size());
	}
	
	/**
	 * Test delete courrier.
	 */
	@Test
	public void testDeleteCourrier() {
		courrierRepo.delete(new Courrier(9L, "Potato Head Groove Thing", "potato@gmail.com", 5, true));
		assertEquals(8, courrierRepo.findAll().size());
	}
	
	/**
	 * Test update courrier.
	 */
	@Test
	public void testUpdateCourrier() {
		// TODO test if updated object matches the one in database, verify the recording went smoothly without exceptions etc
	}
}
