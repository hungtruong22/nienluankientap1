package controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class timkiemController
 */
@WebServlet("/timkiemController")
public class timkiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timkiemController() {
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
		String tk = request.getParameter("search");
		ArrayList<monanbean> dstk = mabo.searchByName(tk);
		request.setAttribute("dssanpham", dstk);
		String maid = request.getParameter("maid");
		monanbean food = mabo.getMonanById(maid);
		request.setAttribute("food", food);
		String maloai = request.getParameter("maloai");
//		ArrayList<monanbean> list = sbo.getmonanByCategory(maloai);
//		request.setAttribute("dsmonan", list);
		 ArrayList<loaibean> dsloai = lbo.getloai();
	     request.setAttribute("dsloai", dsloai);
	     monanbean last = mabo.getNewFood();
	     request.setAttribute("last", last);
	     request.setAttribute("maloai", maloai);
	     request.setAttribute("tk", tk);
		RequestDispatcher rd = request.getRequestDispatcher("./view/web/htsanpham.jsp");
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
