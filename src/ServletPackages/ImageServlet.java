package ServletPackages;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import ModelPackage.Student;

@WebServlet("/ImageServlet")
public class ImageServlet extends ConnexionServlet {
	private static final long serialVersionUID = 1L;
	private String imagePath;

	public void init() throws ServletException {

		this.imagePath = "C:/fic/";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		String maPhoto = null;
		System.out.println();
		Student student = (Student) request.getSession().getAttribute("student");
		try {
			connection = this.getDataSource().getConnection();
			ResultSet rs = ComputeQueryBean.selectPseudo(connection, student.getPseudo());
			while (rs.next()) {
				maPhoto = rs.getString(1);
				System.out.println(maPhoto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String requestedImage = maPhoto;
		if (requestedImage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		System.out.println(imagePath);
		File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
		if (!image.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		String contentType = getServletContext().getMimeType(image.getName());
		if (contentType == null || !contentType.startsWith("image")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		response.reset();
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(image.length()));
		Files.copy(image.toPath(), response.getOutputStream());
	}

}