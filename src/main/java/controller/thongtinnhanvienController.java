package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.nhanvienbean;
import bo.nhanvienbo;

/**
 * Servlet implementation class thongtinnhanvienController
 */
@WebServlet("/thongtinnhanvienController")
public class thongtinnhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thongtinnhanvienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nhanvienbo nvbo = new nhanvienbo();
		long matk = Long.parseLong(request.getParameter("matk"));
		String chucvu = request.getParameter("chucvu");
		nhanvienbean nv = nvbo.getNVByTKID(matk);
		request.setAttribute("matk", matk);
		request.setAttribute("nv", nv);
		request.setAttribute("chucvu", chucvu);
		RequestDispatcher rd = request.getRequestDispatcher("./view/admin/thongtinnhanvien.jsp");
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
