package web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class PartUploadPro1Servlet
 */
@WebServlet(name = "partUploadPro1", urlPatterns = { "/partUploadPro1" })
@MultipartConfig (
			fileSizeThreshold = 0,
			location="D://upload"
		)
public class PartUploadPro1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartUploadPro1Servlet() {
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
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		System.out.println(writer+ " <-- writer");
		Part part = request.getPart("partFile1");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String contentType = part.getContentType();
		System.out.println(contentType+" <--content-type");
		if(contentType.equals("image/jpg") || contentType.equals("image/jpeg") || contentType.equals("image/png")){
			String contentDisposition = part.getHeader("content-disposition");
			String uploadFileName = getUploadFileName(contentDisposition);
			part.write(uploadFileName);
			File srcFile = new File("D:\\upload\\"+uploadFileName);
			File destFile = new File("D:\\jjdev\\jjdevworkspace_html\\0608class\\WebContent\\imgs\\_"+uploadFileName);
			BufferedImage bi = ImageIO.read(srcFile);
			BufferedImage destbi = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g = destbi.createGraphics();
			g.drawImage(bi, 0, 0, 100, 100, null);
			ImageIO.write(destbi, "jpg", destFile);
			out.println("작성자 "+writer+"님이"+uploadFileName+" 파일을 업로드 하였습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("./fileView.jsp");
			request.setAttribute("file", uploadFileName);
			rd.forward(request, response);
		} else{
			out.print("파일 확장자는 jpg, jpeg, png만 업로드 할 수 있습니다.");
		}
		doGet(request, response);
	}
	
	private String getUploadFileName(String contentDisposition){
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		System.out.println(contentSplitStr[2]);
		int lastPathSeparatorIndex = contentSplitStr[2].indexOf("\"");
		System.out.println(lastPathSeparatorIndex);
		int lastQutosIndex =  contentSplitStr[2].lastIndexOf("\"");
		System.out.println(lastQutosIndex);
		uploadFileName = contentSplitStr[2].substring(lastPathSeparatorIndex + 1, lastQutosIndex);
		return uploadFileName;
		
	}

}
