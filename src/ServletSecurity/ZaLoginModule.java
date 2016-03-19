package ServletSecurity;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class ZaLoginModule implements LoginModule {
	private CallbackHandler callbackHandler=null;
	private boolean authenticationFlag=false;
	public static final String TEST_USERNAME="zauser";
	public static final String TEST_PASSWORD = "password";
	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		return authenticationFlag;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.callbackHandler = callbackHandler;
	}

	@Override
	public boolean login() throws LoginException {
		Callback[] callBackArray = new Callback[2];
		callBackArray[0] = new NameCallback("User Name : ");
		callBackArray[1] = new PasswordCallback("Password : ", false);
		try {
			callbackHandler.handle(callBackArray);
		} catch (IOException | UnsupportedCallbackException e) {
			e.printStackTrace();
		}
		String name=((NameCallback) callBackArray[0]).getName();
		String password = new String (((PasswordCallback) callBackArray[1]).getPassword());
		if(TEST_USERNAME.equals(name) && TEST_PASSWORD.equals(password)){
			System.out.println("Authentication success ...");
			authenticationFlag = true;
		}else{
			System.out.println("Authentication failed ...");
			authenticationFlag = false;
		}
		return authenticationFlag;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
