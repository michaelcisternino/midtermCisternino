package com.cisc181.core;


/**
 * custom class for throwing a person exception
 * @author michaelcisternino
 *
 */

public class PersonException extends Exception {
	private Person person;
	private String error;
	
	public PersonException (Person person, String error) {
		
		this.person = person;
		this.error = error;
	}
	
}
