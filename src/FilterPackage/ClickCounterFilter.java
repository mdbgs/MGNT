package FilterPackage;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ClickCounterFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CliickCounterFilterAccueil - doFilter");
		ServletContext sc=req.getServletContext();
		int counter = (int)sc.getAttribute("counter");
		counter++;
		sc.setAttribute("counter", counter);
		System.out.println("ClickCounterFilter.doFilter() : "+sc.getAttribute("counter"));
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filter) throws ServletException {
		ServletContext sc = filter.getServletContext();
		int counter = 0;
		sc.setAttribute("counter", counter);

	}

}
