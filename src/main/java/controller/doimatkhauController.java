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
import bo.taikhoanbo;

/**
 * Servlet implementation class doimatkhauController
 */
@WebServlet("/doimatkhauController")
public class doimatkhauController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public doimatkhauController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		taikhoanbo tkbo = new taikhoanbo();
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		taikhoanbean tk = (taikhoanbean) session.getAttribute("dn");
		System.out.println("ma: " + tk.getMatk());
		System.out.println("mk: " + tk.getMatkhau());
		System.out.println("tdn: " + tk.getTendn());
		System.out.println("taikhoan: " + tk);
		if (session.getAttribute("dn") == null)
			response.sendRedirect("dangnhapController");
		else {
			String matk = tk.getMatk();
			String tendn = request.getParameter("user");
			String matkhauhientai = request.getParameter("pass");
			String matkhaumoi = request.getParameter("newpass");
			String nhaplaimatkhaumoi = request.getParameter("renewpass");

			if (tendn != null && matkhauhientai != null && matkhaumoi != null && nhaplaimatkhaumoi != null) {
				if (matkhauhientai.equals(tk.getMatkhau())) {
					if (!matkhaumoi.equals(nhaplaimatkhaumoi)) {
						request.setAttribute("tbloi", "Mật khẩu không trùng khớp!");
						rd = request.getRequestDispatcher("htdoimatkhau");
						rd.forward(request, response);
					} else {
						tkbo.doiMK(matk, matkhaumoi);
						request.setAttribute("thanhcong", "Mật khẩu đã được thay đổi");
						rd = request.getRequestDispatcher("htdoimatkhau");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("tbloimkht", "Mật khẩu hiện tại không đúng!");
					rd = request.getRequestDispatcher("htdoimatkhau");
					rd.forward(request, response);
				}
			} else {
				rd = request.getRequestDispatcher("htdoimatkhau");
				rd.forward(request, response);
			}
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
