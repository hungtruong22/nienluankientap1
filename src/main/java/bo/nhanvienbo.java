package bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.monanbean;
import bean.nhanvienbean;
import dao.KetNoi;
import dao.nhanviendao;

public class nhanvienbo {
	nhanviendao nvdao = new nhanviendao();
	ArrayList<nhanvienbean> ds;
	
	public ArrayList<nhanvienbean> getNV() {
		ds = nvdao.getNV();
		return ds;
	}
	
	public nhanvienbean getNVByTKID(long tkid) {
		return nvdao.getNVByTKID(tkid);
	}
	
	public void suaNV(long matk,long manv, String hoten, Date ngaysinh, String noisinh) {
		nvdao.suaNV(matk, manv, hoten, ngaysinh, noisinh);
	}
	
	public void themNV(long matk, String hoten, Date ngaysinh, String noisinh) {
		nvdao.themNV(matk, hoten, ngaysinh, noisinh);
	}
	
	public void xoaNV(long tkid) {
		nvdao.xoaNV(tkid);
	}
	
	public int getTotalStaff() {
		return nvdao.getTotalStaff();
	}
	
	public static void main(String[] args) {
		nhanvienbo nvbo = new nhanvienbo();
		
	}
}
