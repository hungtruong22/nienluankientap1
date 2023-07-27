package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.hoadonthanhtoanbean;
import bo.hoadonthanhtoanbo;
import bo.loaibo;
import bo.monanbo;

/**
 * Servlet implementation class hoadontheongayController
 */
@WebServlet("/hoadontheongayController")
public class hoadontheongayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoadontheongayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			hoadonthanhtoanbo hdttbo = new hoadonthanhtoanbo();
			HttpSession session = request.getSession();
			if (session.getAttribute("dn") == null)
				response.sendRedirect("dangnhapController");
			else { 
				String ngay = request.getParameter("datelist");
				Date date = Date.valueOf(ngay);
				session.setAttribute("date", date);
				System.out.println("ngay: " + ngay);
				ArrayList<hoadonthanhtoanbean> hdtt = hdttbo.getHDByDate(date);
				request.setAttribute("hoadontheongay", hdtt);
				
				
				
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("quanlyhoadonController");
				rd.forward(request, response);
			
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
