package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Mdao;
import dto.Member;

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
		String pw = request.getParameter("pw");
		System.out.println(pw+" <-- doPost()");
		Mdao mdao = new Mdao();
		try {
			String result = mdao.mLogin(id, pw);
			if(result.equals("03로그인성공")){
				System.out.println("03로그인성공");
				Member resultMember = mdao.mgetSession(id);
				HttpSession s = request.getSession();
				s.setAttribute("SID", resultMember.getMember_id());
				response.sendRedirect("./index.jsp");
			}else{
				System.out.println("로그인실패");
				response.sendRedirect("./index.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

}
