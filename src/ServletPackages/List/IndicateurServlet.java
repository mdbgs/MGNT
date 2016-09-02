package ServletPackages.List;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BeanPackage.ComputeQueryBean;
import BeanPackage.IndicateurBean;
import Enumeration.NumericConstant;
import ModelPackage.Indicateur;
import ServletPackages.GetAuthorisationUsers;
import ServletPackages.OutPut.CsvGenerator;

public class IndicateurServlet extends GetAuthorisationUsers implements NumericConstant{

	private Connection connection;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		if (req.getParameter("pageNumber") == null)
			req.setAttribute("pageNumber", 1);
		else
			req.setAttribute("pageNumber", req.getParameter("pageNumber"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/List/Indicateur.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IndicateurBean indicateur = new IndicateurBean();
		String annee=req.getParameter("annee");
		if(annee!=null){
			CsvGenerator generator= new CsvGenerator();
			switch(annee){
			case "2015":{
				generator.yearReport("1");
			}break;
			case "2016":{
				generator.yearReport("2");
			}break;
			case "2017":{
				generator.yearReport("3");
				
			}break;
			case "2018":{
				generator.yearReport("4");
			}break;
			}
			String urlAndFileName = urlOutPut + fileReportName + 4 + ".xls";
			File file =new File(urlAndFileName);
			if(!file.exists())
		    {
		        throw new ServletException("File doesn't exists on server.");
		    }
			resp.setContentType("APPLICATION/OCTET-STREAM");
		    resp.setHeader("Content-Disposition","attachment; filename=\"" + fileReportName + 4 + ".xls" + "\""); 

		    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(urlAndFileName);

		    int i; 
		    while ((i=fileInputStream.read()) != -1) 
		    {
		         resp.getWriter().write(i); 
		    } 
		    fileInputStream.close();
		}
		System.out.println(annee);
		try {
			connection = this.getDataSource().getConnection();
			ResultSet result = ComputeQueryBean.selectAll("indicateur", connection);
			while (result.next()) {
				indicateur.addIndicateurInList(new Indicateur(result.getInt(1), result.getInt(2), result.getString(3),
						result.getString(4), result.getString(5)));
			}
			System.out.println("Taille de la liste : " + indicateur.getIndicateurList().size());
			req.setAttribute("indicateurRecu", indicateur);
			req.setAttribute("rowsCount", indicateur.getIndicateurList().size());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
