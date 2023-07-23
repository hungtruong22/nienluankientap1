package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadonthanhtoanbean;
import bean.loaibean;
import bean.monanbean;
import bean.taikhoanbean;


public class taikhoandao {
	public ArrayList<taikhoanbean> getTK(){
    	ArrayList<taikhoanbean> ds= new ArrayList<taikhoanbean>();
    	try {
			//B1: ket noi vao csdl 
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from taikhoan";
    		PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String matk = rs.getString("matk");
    			String tendn = rs.getString("tendn");
    			String matkhau = rs.getString("matkhau");
    			boolean lanhanvien = rs.getBoolean("lanhanvien");
    			boolean laquanly = rs.getBoolean("laquanly");
    			ds.add(new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly));
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public taikhoanbean login(String user, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select * from taikhoan\r\n"
					+ "where tendn = ? and matkhau = ?";
			PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, user);
    		cmd.setString(2, pass);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String matk = rs.getString("matk");
    			String tendn = rs.getString("tendn");
    			String matkhau = rs.getString("matkhau");
    			boolean lanhanvien = rs.getBoolean("lanhanvien");
    			boolean laquanly = rs.getBoolean("laquanly");
				return new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public taikhoanbean kiemtrataikhoantontai(String user) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from taikhoan\r\n"
					+ "where tendn=?";
			PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, user);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String matk = rs.getString("matk");
    			String tendn = rs.getString("tendn");
    			String matkhau = rs.getString("matkhau");
    			boolean lanhanvien = rs.getBoolean("lanhanvien");
    			boolean laquanly = rs.getBoolean("laquanly");
				return new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void signup(String user, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into taikhoan\r\n"
					+ "values(?,?,1,0)";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, user);
			cmd.setString(2, pass);
			cmd.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTotalAcc() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select count(*) from taikhoan";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			return rs.getInt(1);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ArrayList<taikhoanbean> pagingAcc(int index){
		ArrayList<taikhoanbean> list = new ArrayList<taikhoanbean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select * from taikhoan\r\n"
					+ "order by matk\r\n"
					+ "offset ? rows fetch next 6 rows only";
			
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, (index-1)*6);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String matk=rs.getString("matk");
				String tendn=rs.getString("tendn");
				String matkhau=rs.getString("matkhau");
				boolean lanhanvien=rs.getBoolean("lanhanvien");
				boolean laquanly=rs.getBoolean("laquanly");
				list.add(new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly));
    		}
    		rs.close();
			kn.cn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public taikhoanbean getMK(long tkid) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select matkhau\r\n"
					+ "from taikhoan\r\n"
					+ "where matk = ?";
			
			PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setLong(1, tkid);		
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String matkhau = rs.getString("matkhau");
    			return new taikhoanbean(matkhau);
    		}
    		rs.close();
    		kn.cn.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public taikhoanbean getAccById(String id){
		ArrayList<taikhoanbean> ds = new ArrayList<taikhoanbean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from taikhoan\r\n"
    				+ "where matk=?;";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, id);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String matk=rs.getString("matk");
				String tendn=rs.getString("tendn");
				String matkhau=rs.getString("matkhau");
				boolean lanhanvien=rs.getBoolean("lanhanvien");
				boolean laquanly=rs.getBoolean("laquanly");
				return new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly);
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void suaTK(String matk, String tendn, String matkhau, boolean lanhanvien, boolean laquanly) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql= "update taikhoan\r\n"
					+ "set tendn=?,\r\n"
					+ "	matkhau=?,\r\n"
					+ "	lanhanvien=?,\r\n"
					+ "	laquanly=?\r\n"
					+ "where matk=?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, matkhau);
			cmd.setBoolean(3, lanhanvien);
			cmd.setBoolean(4, laquanly);
			cmd.setString(5, matk);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xoaTK(String tkid) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete from taikhoan\r\n"
					+ "where matk = ?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tkid);		
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doiMK(String matk, String matkhau) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql= "update taikhoan\r\n"
					+ "set matkhau=?\r\n"
					+ "where matk=?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, matkhau);
			cmd.setString(2, matk);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		taikhoandao tkdao = new taikhoandao();
		
	}
}
