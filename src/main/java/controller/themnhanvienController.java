package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.taikhoanbean;
import bo.loaibo;
import bo.monanbo;
import bo.nhanvienbo;
import bo.taikhoanbo;

/**
 * Servlet implementation class themnhanvienController
 */
@WebServlet("/themnhanvienController")
public class themnhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themnhanvienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("dn") == null)
				response.sendRedirect("dangnhapController");
			else {
				nhanvienbo nvbo = new nhanvienbo();
				long matknv = Long.parseLong(request.getParameter("matknv"));
				String hotennv = request.getParameter("hotennv");
				String ngaysinhnv = request.getParameter("ngaysinhnv");
				Date date = Date.valueOf(ngaysinhnv);
				String noisinhnv = request.getParameter("noisinhnv");
				
				nvbo.themNV(matknv, hotennv, date, noisinhnv);
				RequestDispatcher rd = request.getRequestDispatcher("quanlytaikhoanController");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
