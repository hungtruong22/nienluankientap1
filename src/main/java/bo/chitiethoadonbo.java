package bo;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.chitiethoadonbean;
import bean.monanbean;
import dao.KetNoi;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao = new chitiethoadondao();
	ArrayList<chitiethoadonbean> ds;
	
	public ArrayList<chitiethoadonbean> getCTHD(){
		ds = ctdao.getCTHD();
		return ds;
	}
	public int Them(String mamonan, String tenmonan, long soluongdat, long maxmahd) {
		return ctdao.Them(mamonan, tenmonan, soluongdat, maxmahd);
	}
	
	public chitiethoadonbean getHoadonById(long hdid) {
		return ctdao.getHoadonById(hdid);
	}
	
	public chitiethoadonbean getNewMaHD() {
		return ctdao.getNewMaHD();
	}
	
	public static void main(String[] args) {
		chitiethoadonbo ctbo = new chitiethoadonbo();
		
	}
}
