package org.jivesoftware.smack.sasl;

/**
 * author:Amrit Raj
 */

import javax.security.auth.callback.CallbackHandler;

import org.jivesoftware.smack.SmackException;

public class SASLPlain extends SASLMechanism{

	public static final String NAME = "PLAIN";
	
	@Override
	protected void authenticateInternal(CallbackHandler cbh)
			throws SmackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected byte[] getAuthenticationText() throws SmackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return NAME;
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public void checkIfSuccessfulOrThrow() throws SmackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected SASLMechanism newInstance() {
		// TODO Auto-generated method stub
		return new SASLPlain();
	}

}
