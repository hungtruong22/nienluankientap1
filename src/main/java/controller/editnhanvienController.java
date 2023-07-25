package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.nhanvienbean;
import bo.nhanvienbo;
import bo.taikhoanbo;

/**
 * Servlet implementation class editnhanvienController
 */
@WebServlet("/editnhanvienController")
public class editnhanvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editnhanvienController() {
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
		nhanvienbo nvbo = new nhanvienbo();
		long matk = Long.parseLong(request.getParameter("matk"));
		long manv = Long.parseLong(request.getParameter("manv"));
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		Date date = Date.valueOf(ngaysinh);
		String noisinh = request.getParameter("noisinh");
		nvbo.suaNV(matk, manv, hoten, date, noisinh);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("thongtinnhanvienController");
		rd.forward(request, response);
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
