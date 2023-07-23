package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;
import bo.monanbo;

/**
 * Servlet implementation class themController
 */
@WebServlet("/themController")
public class themController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
		monanbo mabo = new monanbo();
		loaibo lbo = new loaibo();
		
		String masanpham = request.getParameter("masanpham");
		String tensanpham = request.getParameter("tensanpham");
		long giasanpham = Long.parseLong(request.getParameter("giasanpham"));
		String anhsanpham = request.getParameter("anhsanpham");
		/* String anh = "anhmonan/"+anhsanpham; */
		String loaisanpham = request.getParameter("loaisanpham");
		/* System.out.println("link anh:" + anh); */
		HttpSession session= request.getSession();
		session.getAttribute("dn");
		mabo.them(masanpham, tensanpham, giasanpham, anhsanpham, loaisanpham);
		response.sendRedirect("quanlymonanController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
