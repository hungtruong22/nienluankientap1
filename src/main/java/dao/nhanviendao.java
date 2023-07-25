package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.monanbean;
import bean.nhanvienbean;

public class nhanviendao {
	public ArrayList<nhanvienbean> getNV(){
		try {
			ArrayList<nhanvienbean> ds = new ArrayList<nhanvienbean>();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select * from nhanvien";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			
			//B3: Duyet rs de luu vao
			while(rs.next()) {
				// lay ve maloai a tenloai
				long manv=rs.getLong("manv");
				long matk=rs.getLong("matk");
				String hotennv=rs.getString("hotennv");
				Date ngaysinh=rs.getDate("ngaysinh");
				String noisinh=rs.getString("noisinh");
				ds.add(new nhanvienbean(manv, matk, hotennv, ngaysinh, noisinh));
			}
			
			//B4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public nhanvienbean getNVByTKID(long tkid) {
		ArrayList<nhanvienbean> ds = new ArrayList<nhanvienbean>();
		try {
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select nhanvien.*, taikhoan.matk\r\n"
    				+ "from nhanvien join taikhoan\r\n"
    				+ "on nhanvien.matk = taikhoan.matk\r\n"
    				+ "where taikhoan.matk = ?\r\n"
    				+ "";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setLong(1, tkid);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			long manv=rs.getLong("manv");
				long matk=rs.getLong("matk");
				String hotennv=rs.getString("hotennv");
				Date ngaysinh=rs.getDate("ngaysinh");
				String noisinh=rs.getString("noisinh");
				return new nhanvienbean(manv, matk, hotennv, ngaysinh, noisinh);
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void suaNV(long matk,long manv, String hoten, Date ngaysinh, String noisinh) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql= "update nhanvien\r\n"
					+ "set hotennv=?,\r\n"
					+ "	ngaysinh = ?,\r\n"
					+ "	noisinh = ?\r\n"
					+ "	where matk= ?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, hoten);
			cmd.setDate(2, (java.sql.Date) ngaysinh);
			cmd.setString(3, noisinh);
			cmd.setLong(4, matk);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void themNV(long matk, String hoten, Date ngaysinh, String noisinh) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="insert into nhanvien(matk,hotennv,ngaysinh,noisinh)\r\n"
					+ "values(?,?,?,?)";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, matk);
			cmd.setString(2, hoten);
			cmd.setDate(3, (java.sql.Date) ngaysinh);
			cmd.setString(4, noisinh);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xoaNV(long tkid) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete from nhanvien\r\n"
					+ "where matk = ?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, tkid);		
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
