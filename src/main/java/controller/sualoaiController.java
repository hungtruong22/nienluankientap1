package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.monanbean;
import bo.loaibo;
import bo.monanbo;

/**
 * Servlet implementation class sualoaiController
 */
@WebServlet("/sualoaiController")
public class sualoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sualoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		monanbo mabo = new monanbo();
		loaibo lbo = new loaibo();
		String loaiid = request.getParameter("maloai");
		loaibean loai = lbo.getLoaiById(loaiid);
		request.setAttribute("type", loai);
		
		RequestDispatcher rd = request.getRequestDispatcher("quanlyloaiController");
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
