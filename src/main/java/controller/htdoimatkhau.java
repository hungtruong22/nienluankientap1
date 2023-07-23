package controller;

import java.io.IOException;

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
 * Servlet implementation class htdoimatkhau
 */
@WebServlet("/htdoimatkhau")
public class htdoimatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htdoimatkhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("dn") == null)
			response.sendRedirect("dangnhapController");
		else {
			taikhoanbo tkbo = new taikhoanbo();
			String accid = request.getParameter("mtk");
			String mktk = request.getParameter("mk");
			taikhoanbean acc = tkbo.getAccById(accid);
			request.setAttribute("acc", acc);
			request.setAttribute("mktk", mktk);
			RequestDispatcher rd = request.getRequestDispatcher("./view/web/doimatkhau.jsp");
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
