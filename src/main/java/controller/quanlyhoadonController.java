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
import bean.loaibean;
import bo.hoadonthanhtoanbo;
import bo.loaibo;
import bo.monanbo;

/**
 * Servlet implementation class quanlyhoadonController
 */
@WebServlet("/quanlyhoadonController")
public class quanlyhoadonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlyhoadonController() {
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
		hoadonthanhtoanbo hdttbo = new hoadonthanhtoanbo();
		HttpSession session = request.getSession();
		if (session.getAttribute("dn") == null)
			response.sendRedirect("dangnhapController");
		else {
			ArrayList<hoadonthanhtoanbean> hdgetngay = hdttbo.getNgay();
			System.out.println(hdgetngay);
			hoadonthanhtoanbean hd = null;
			request.setAttribute("hdgetngay", hdgetngay);
			ArrayList<hoadonthanhtoanbean> dshdon = hdttbo.HienThiHDALL();
			/* ArrayList<hoadonthanhtoanbean> dshd = hdttbo.HienThi(hd.getMahd()); */
			request.setAttribute("dshdon", dshdon);
			Date date = (Date) session.getAttribute("date");
			System.out.println("ngay no: " + date);
			String indexPage = request.getParameter("trang");

			if (indexPage == null) {
				indexPage = "1";
			}
			int trang = Integer.parseInt(indexPage);
			int dem = hdttbo.getTotalHDByDate(date);

			int endPage = dem / 6;
			if (dem % 6 != 0) {
				endPage++;
			}

			ArrayList<hoadonthanhtoanbean> dstrang = hdttbo.pagingHD(trang, date);
			request.setAttribute("dstrang", dstrang);
			System.out.println("trang: " + trang);
			System.out.println("danh sach: " + dstrang);
			request.setAttribute("endPage", endPage);
			request.setAttribute("tag", trang);
			RequestDispatcher rd = request.getRequestDispatcher("./view/admin/quanlyhoadon.jsp");
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
