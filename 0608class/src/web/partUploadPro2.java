package web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class partUploadPro2
 */
@WebServlet("/partUploadPro2")
@MultipartConfig(
			fileSizeThreshold=0,
			location="D://upload"
		)

public class partUploadPro2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public partUploadPro2() {
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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String writer = request.getParameter("writer");
		System.out.println(writer+" <-- writer");
		String uploadFileNameList = "";
		String uploadFileName = null;
		for(Part part:request.getParts()){
			if(!part.getName().equals("writer")){
				while(!part.getName().equals("")){
				String contentDisposition = part.getHeader("content-disposition");
				uploadFileName = getUploadFileName(contentDisposition);
				part.write(uploadFileName);
				uploadFileNameList += " "+uploadFileName;
				}
			}else{
				System.out.println("x");
			}
		}
		out.println("작성자 "+writer+"님이 "+uploadFileNameList+"파일을 업로드 하였습니다.");
		File srcFile = new File("D:\\upload\\"+uploadFileName);
		File destFile = new File("D:\\upload\\_"+uploadFileName);
		BufferedImage bi = ImageIO.read(srcFile);
		BufferedImage destbi = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = destbi.createGraphics();
		g.drawImage(bi, 0, 0, 100, 100, null);
		ImageIO.write(destbi, "jpg", destFile);
		doGet(request, response);
	}
	
	private String getUploadFileName(String contentDisposition){
		String uploadFileName=null;
		String[] contentSplitStr = contentDisposition.split(";");
		System.out.println(contentSplitStr[2]);
		int SeparatorIndex = contentSplitStr[2].indexOf("\"");
		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
		System.out.println(SeparatorIndex+" <-- index1");
		System.out.println(lastQutosIndex+" <-- index2");
		uploadFileName = contentSplitStr[2].substring(SeparatorIndex+1, lastQutosIndex);
		System.out.println(uploadFileName+" <-- uploadFileName");
		return uploadFileName;
	}
}
