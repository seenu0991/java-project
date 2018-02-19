package exception;

import datamodel.Identity;

public class IdentityException extends Exception {
	
	
	Identity faultyIdentity;
	
	
	
	
	public IdentityException(Identity identity, Exception originalCause) {
		faultyIdentity = identity;
		initCause(originalCause);

	}

}
