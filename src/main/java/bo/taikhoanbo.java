package bo;

import java.util.ArrayList;

import bean.giohangbean;
import bean.monanbean;
import bean.taikhoanbean;
import dao.taikhoandao;

public class taikhoanbo {
	taikhoandao tkdao = new taikhoandao();
	ArrayList<taikhoanbean> ds;
	public ArrayList<taikhoanbean> getTK(){
		   ds=tkdao.getTK();
		   return ds;
	   }
	public taikhoanbean login(String user, String pass) {
		   return tkdao.login(user, pass);
	   }
	public taikhoanbean kiemtrataikhoantontai(String user) {
		   return tkdao.kiemtrataikhoantontai(user);
	   }   
	public void signup(String user, String pass) {
		 tkdao.signup(user, pass);
	}
	
	public int getTotalAcc() {
		return tkdao.getTotalAcc();
	}

	public ArrayList<taikhoanbean> pagingAcc(int index) {
		return tkdao.pagingAcc(index);
	}
	
	public taikhoanbean getMK(long tkid) {
		return tkdao.getMK(tkid);
	}
	
	public taikhoanbean getAccById(String tkid) {
		return tkdao.getAccById(tkid);
	}
	
	public void suaTK(String matk, String tendn, String matkhau, boolean lanhanvien, boolean laquanly) {
		tkdao.suaTK(matk, tendn, matkhau, lanhanvien, laquanly);
	}
	
	public void xoaTK(String tkid) {
		tkdao.xoaTK(tkid);
	}
	
	public void doiMK(String matk, String matkhau) {
		tkdao.doiMK(matk, matkhau);
	}
	
	public static void main(String[] args) {
		taikhoanbo tkbo = new taikhoanbo();
		tkbo.login("minhhung", "123");
	}
	
}
