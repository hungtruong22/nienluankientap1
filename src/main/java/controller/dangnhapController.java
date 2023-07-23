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
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		taikhoanbo tkbo = new taikhoanbo();
		String tendn = request.getParameter("user");
		String matkhau = request.getParameter("pass");

		RequestDispatcher rd;
		  if(tendn!=null&&matkhau!=null){
			  taikhoanbean tk= tkbo.login(tendn, matkhau);
		  if(tk!=null){
			  //Tao ra doi tuong session
			  HttpSession session=request.getSession();
			  session.setAttribute("dn", tk);
			   rd= request.getRequestDispatcher("htsanpham");
			}else { //Dang nhap sai
				request.setAttribute("thongbaoloi", "Sai tên đăng nhập hoặc mật khẩu!");
				rd= request.getRequestDispatcher("./view/web/dangnhap.jsp?kt=1");
			}
		  } else//Chay lan dau
			  rd= request.getRequestDispatcher("./view/web/dangnhap.jsp");
		  
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
