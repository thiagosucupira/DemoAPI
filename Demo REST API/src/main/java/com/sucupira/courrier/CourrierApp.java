package com.sucupira.courrier;

import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sucupira.courrier.resource.jaxws.CourrierResourceSOAP;

/**
 * The Class CourrierApp.
 */
@SpringBootApplication
public class CourrierApp {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CourrierApp.class, args); 
		System.out.println("REST on air!");

		Endpoint.publish("http://localhost:8888/SOAP/courriers", new CourrierResourceSOAP());
		System.out.println("SOAP on air!");
	}
}
