package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.monanbean;
import bean.taikhoanbean;
import bo.loaibo;
import bo.monanbo;
import bo.taikhoanbo;

/**
 * Servlet implementation class quanlytaikhoanController
 */
@WebServlet("/quanlytaikhoanController")
public class quanlytaikhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quanlytaikhoanController() {
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
		/* taikhoanbean tk=(taikhoanbean)session.getAttribute("dn"); */
		if (session.getAttribute("dn") == null)
			response.sendRedirect("dangnhapController");
		else {
			ArrayList<taikhoanbean> dstk = tkbo.getTK();
			request.setAttribute("dstk", dstk);
			/* taikhoanbean matkhau = tkbo.getMK(Long.parseLong(tk.getMatk())); */
			System.out.println("dstk: " + dstk);

			/*
			 * String mksao = ""; String gan = ""; ArrayList<String> arrmk = new
			 * ArrayList<String>(); for (taikhoanbean s : dstk) { mksao = ""; gan = ""; int
			 * n = s.getMatkhau().length(); System.out.println("do dai:" + n); while (n > 0)
			 * { mksao += "*"; gan = mksao; System.out.println("matkhau" + mksao); n--; }
			 * arrmk.add(gan); request.setAttribute("ganmk", gan); System.out.println("gan"
			 * + gan); } System.out.println(arrmk); request.setAttribute("arrmk", arrmk);
			 */

			/* String mk = matkhau.getMatkhau(); */

			/*
			 * System.out.println("mat khau:" + mk);
			 * 
			 * System.out.println("do dai" + n);
			 */
			String indexPage = request.getParameter("trang");

			if (indexPage == null) {
				indexPage = "1";
			}
			int trang = Integer.parseInt(indexPage);

			int dem = tkbo.getTotalAcc();

			int endPage = dem / 6;
			if (dem % 3 != 0) {
				endPage++;
			}

			ArrayList<taikhoanbean> dstrang = tkbo.pagingAcc(trang);
			request.setAttribute("dstrang", dstrang);

			request.setAttribute("endPage", endPage);
			request.setAttribute("tag", trang);

			RequestDispatcher rd = request.getRequestDispatcher("./view/admin/quanlytaikhoan.jsp");
			rd.forward(request, response);
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
