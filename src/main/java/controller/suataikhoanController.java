package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.monanbean;
import bean.taikhoanbean;
import bo.loaibo;
import bo.monanbo;
import bo.taikhoanbo;

/**
 * Servlet implementation class suataikhoanController
 */
@WebServlet("/suataikhoanController")
public class suataikhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suataikhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		taikhoanbo tkbo = new taikhoanbo();
		String tkid = request.getParameter("mataikhoan");
		taikhoanbean account = tkbo.getAccById(tkid);
		request.setAttribute("account", account);
		
		RequestDispatcher rd = request.getRequestDispatcher("quanlytaikhoanController");
	       rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
