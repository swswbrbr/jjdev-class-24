package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalCompiler
 */
@WebServlet("/cal.do")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청분석&요청파라미터분석 -> 컨트롤드 레이어
		request.setCharacterEncoding("UTF-8");
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String oper = request.getParameter("oper");
		System.out.println(x+" <-- int x");
		System.out.println(y+" <-- int y");
		System.out.println(oper+" <-- String oper");
		
		//2.비즈니스로직(service logic) -> 서비스 레이어
		int result = 0;
		CalService cs = new CalService();
		if(oper.equals("add")){
			result = cs.add(x, y);
		} else if(oper.equals("min")){
			result = cs.min(x, y);
		} else if(oper.equals("mul")){
			result = cs.mul(x, y);
		} else if(oper.equals("div")) {
			result = cs.div(x, y);
		}
		
		//3.출력(뷰) -> 뷰 레이어
		//response.sendRedirect("./calView.jsp?result="+result);
		RequestDispatcher rd = request.getRequestDispatcher("./calView.jsp");
		request.setAttribute("result", result);
		rd.forward(request, response);
		doGet(request, response);
	}

}
