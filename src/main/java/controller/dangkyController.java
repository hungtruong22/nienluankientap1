package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.taikhoanbean;
import bo.loaibo;
import bo.monanbo;
import bo.taikhoanbo;
import dao.taikhoandao;

/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			monanbo mabo = new monanbo();
			loaibo lbo = new loaibo();
			taikhoanbo tkbo = new taikhoanbo();
			taikhoandao tkdao = new taikhoandao();
			String tendn = request.getParameter("user");
			String matkhau = request.getParameter("pass");
			String nhaplaimatkhau = request.getParameter("repass");
			RequestDispatcher rd;
			
			if(tendn != null && matkhau != null && nhaplaimatkhau != null) {
				if(!matkhau.equals(nhaplaimatkhau)) {
					request.setAttribute("tbloi", "Mật khẩu không trùng khớp!");
					rd= request.getRequestDispatcher("./view/web/dangky.jsp");
					rd.forward(request, response);
				}
				else {
					taikhoanbean tk = tkbo.kiemtrataikhoantontai(tendn);
					if(tk == null) { // tai khoan chua co thi dc dang ky
						tkbo.signup(tendn, matkhau);
						rd= request.getRequestDispatcher("./view/web/dangnhap.jsp");
						rd.forward(request, response);
					}
					else {
						request.setAttribute("tbloidk", "Tên đăng nhập đã tồn tại!");
						rd= request.getRequestDispatcher("./view/web/dangky.jsp");
						rd.forward(request, response);
					}
				}
			}
			else { // chạy lần đầu
				rd= request.getRequestDispatcher("./view/web/dangky.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
