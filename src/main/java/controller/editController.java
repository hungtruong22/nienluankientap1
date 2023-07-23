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
 * Servlet implementation class editController
 */
@WebServlet("/editController")
public class editController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editController() {
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
		
		String mahang = request.getParameter("mamh");
		String tenhang = request.getParameter("tenmh");
		long giahang = Long.parseLong(request.getParameter("giamh"));
		String anhhang = request.getParameter("anhmh");
		String loaihang = request.getParameter("loaimh");
		mabo.sua(mahang, tenhang, giahang, anhhang, loaihang);
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
