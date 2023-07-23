package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.chitiethoadonbean;
import bean.giohangbean;
import bean.taikhoanbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;
import bo.hoadonthanhtoanbo;

/**
 * Servlet implementation class datmonanController
 */
@WebServlet("/datmonanController")
public class datmonanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public datmonanController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			taikhoanbean tk = (taikhoanbean) session.getAttribute("dn");
			if (tk == null)
				response.sendRedirect("dangnhapController");
			else {
				hoadonbo hdbo = new hoadonbo();
				chitiethoadonbo ctbo = new chitiethoadonbo();
				giohangbo gh = (giohangbo) session.getAttribute("gio");
				float tongtien = Float.parseFloat(request.getParameter("tongtien"));
				float giakm = Float.parseFloat(request.getParameter("giakhuyenmai"));
				float thanhtoan = Float.parseFloat(request.getParameter("thanhtoan"));
				String tennhanvien = request.getParameter("nhanvien");
				
				// Tao ra 1 hoa don
				hdbo.Them(tk.getMatk());
				long maxmahd = hdbo.maxhd();
				
				// Tao ra cac chi tiet hoa don
				for (giohangbean g : gh.ds)
					ctbo.Them(g.getMamonan(), g.getTenmonan(), g.getSoluong(), maxmahd);
				chitiethoadonbean hdtt = ctbo.getNewMaHD();
				  session.setAttribute("hdtt", hdtt);
				session.removeAttribute("gio");
				System.out.println(tongtien);
				System.out.println(tennhanvien);
				request.setAttribute("tongtien", tongtien);
				request.setAttribute("giakm", giakm);
				request.setAttribute("thanhtoan", thanhtoan);
				request.setAttribute("tennhanvien", tennhanvien);
				/* response.sendRedirect("hoadonController"); */
				RequestDispatcher rd= request.getRequestDispatcher("hoadonController");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("lỗi:" + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
