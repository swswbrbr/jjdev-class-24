package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getServlet
 */
@WebServlet(name = "GetServlet", urlPatterns = { "/GetServlet" })
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String id = request.getParameter("id");
		System.out.println(id+" <--doGet()");
		response.setContentType("text/html; charset=utf-8"); 
		*/
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id+" <-- doPost()");
		
		response.setContentType("text/html; charset=utf-8"); 
		doGet(request, response);
	}

}
