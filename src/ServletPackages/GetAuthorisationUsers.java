package ServletPackages;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import ModelPackage.User;

public class GetAuthorisationUsers extends ConnexionServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response, String roleUser, String page,
			Connection connection) throws ServletException, IOException {
		String role = null;
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			role = ComputeQueryBean.userRole(user.getPseudo(), connection);
			if (role.equals(roleUser)) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + page).forward(request, response);
			} else {
				request.getSession().invalidate();
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connection.jsp").forward(request, response);
			}
		} else {

			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connection.jsp").forward(request, response);
		}
	}
}
