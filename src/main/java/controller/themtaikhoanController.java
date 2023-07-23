package controller;

import java.io.IOException;

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
import bo.taikhoanbo;
import dao.taikhoandao;

/**
 * Servlet implementation class themtaikhoanController
 */
@WebServlet("/themtaikhoanController")
public class themtaikhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themtaikhoanController() {
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
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("dn") == null)
				response.sendRedirect("dangnhapController");
			else {
				taikhoanbo tkbo = new taikhoanbo();
				String tendn = request.getParameter("tentaikhoan");
				String matkhau = request.getParameter("matkhautaikhoan");
				String nhaplaimatkhau = request.getParameter("nhaplaimatkhautaikhoan");
				RequestDispatcher rd;

				if (tendn != null && matkhau != null && nhaplaimatkhau != null) {
					if (!matkhau.equals(nhaplaimatkhau)) {
						request.setAttribute("tbloi", "Mật khẩu không trùng khớp!");
						rd = request.getRequestDispatcher("quanlytaikhoanController");
						rd.forward(request, response);
					} else {
						taikhoanbean tk = tkbo.kiemtrataikhoantontai(tendn);
						if (tk == null) { // tai khoan chua co thi dc dang ky
							tkbo.signup(tendn, matkhau);
							rd = request.getRequestDispatcher("quanlytaikhoanController");
							rd.forward(request, response);
						} else {
							request.setAttribute("tbloidk", "Tên đăng nhập đã tồn tại!");
							rd = request.getRequestDispatcher("quanlytaikhoanController");
							rd.forward(request, response);
						}
					}
				} else { // chạy lần đầu
					rd = request.getRequestDispatcher("quanlytaikhoanController");
					rd.forward(request, response);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
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
