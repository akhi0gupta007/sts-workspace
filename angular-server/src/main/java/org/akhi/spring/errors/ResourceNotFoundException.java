package org.akhi.spring.errors;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Above resource is not found");
	}

}
