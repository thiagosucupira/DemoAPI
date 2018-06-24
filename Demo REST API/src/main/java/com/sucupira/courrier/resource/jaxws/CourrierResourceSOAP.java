package com.sucupira.courrier.resource.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;

import com.sucupira.courrier.model.Courrier;
import com.sucupira.courrier.repository.CourrierRepo;

/**
 * The Class CourrierResourceSOAP.
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public class CourrierResourceSOAP {
	
	/** The courrier repo. */
	@Autowired
	private CourrierRepo courrierRepo;
	
	/**
	 * Fetch all courriers.
	 *
	 * @return the list
	 */
	@WebMethod
	public List<Courrier> fetchAllCourriers() {
		return  courrierRepo.findAll();
	}
}
