package ServletSecurity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticationServlet
 */
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter= response.getWriter();
		printWriter.println("<html><head><title>JAAS web Authentication</title><body>");
		String user=request.getParameter("user");
		String password= request.getParameter("password");
		if(!user.isEmpty() && !password.isEmpty()){
			boolean authenticationFlag=true;
			ZaCallbackHandler zaCallbackHandler = new ZaCallbackHandler(user, password);
			try {
				LoginContext loginContext = new LoginContext("ZaJaas", zaCallbackHandler);
				loginContext.login();
			} catch (LoginException e) {
				e.printStackTrace();
				printWriter.println("LoginContext failed");
				authenticationFlag=false;
			}
			if(authenticationFlag) printWriter.println("Authentication success ...");
			else printWriter.println("Authentication failed ...");
		}else{
			response.getWriter().println(" Invalid Authentication ...");
		}
		printWriter.println("</body></html>");
	}
}
