package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.chitiethoadonbean;
import bean.hoadonbean;
import bean.hoadonthanhtoanbean;
import bean.loaibean;
import bean.taikhoanbean;
import bo.chitiethoadonbo;
import bo.hoadonbo;
import bo.hoadonthanhtoanbo;
import bo.loaibo;

/**
 * Servlet implementation class hoadonController
 */
@WebServlet("/hoadonController")
public class hoadonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoadonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loaibo lbo=new loaibo();
			ArrayList<loaibean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai); 
			HttpSession session=request.getSession();
			taikhoanbean tk=(taikhoanbean)session.getAttribute("dn");
			if(tk==null) {
				response.sendRedirect("dangnhapController");
			}else {
				chitiethoadonbean hdon = (chitiethoadonbean)session.getAttribute("hdtt");
				hoadonthanhtoanbo hdttbo = new hoadonthanhtoanbo(); 
				hoadonbean hd = new hoadonbean();
				ArrayList<hoadonthanhtoanbean> hdtt = hdttbo.HienThi(hdon.getMahd());
				System.out.println(hdon.getMahd());
				hoadonthanhtoanbean ngaymua = hdttbo.getNgaymua(hdon.getMahd());
				System.out.println("ngay mua: " + ngaymua.getNgaymua());
				Date tgian = ngaymua.getNgaymua();
				if (hdtt != null) {
					request.setAttribute("hoadonthanhtoan", hdtt);
					request.setAttribute("tgian", tgian);
					}
				RequestDispatcher rd= request.getRequestDispatcher("./view/web/hoadon.jsp");
				rd.forward(request, response);
		}
		} catch (Exception e) {
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
