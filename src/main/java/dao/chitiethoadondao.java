package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitiethoadonbean;
import bean.monanbean;



public class chitiethoadondao {
	
	public ArrayList<chitiethoadonbean> getCTHD(){
		ArrayList<chitiethoadonbean> ds = new ArrayList<chitiethoadonbean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from chitiethoadon";
    		PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			long macthd=rs.getLong("macthd");
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				long soluongmua=rs.getLong("soluongmua");
				long mahd=rs.getLong("mahd");
				boolean damua=rs.getBoolean("damua");
				ds.add(new chitiethoadonbean(macthd, mamonan, tenmonan, soluongmua, mahd, damua));
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
	
	public int Them(String mamonan, String tenmonan, long soluongmua, long maxmahd) {
		try {
			KetNoi kn= new KetNoi();
			kn.KetNoi();
			String sql="insert into chitiethoadon(mamonan, tenmonan, soluongmua, mahd, damua) values(?,?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, mamonan);
			cmd.setString(2, tenmonan);
			cmd.setLong(3, soluongmua);
			cmd.setLong(4, maxmahd);
			cmd.setBoolean(5, true);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public chitiethoadonbean getHoadonById(long hdid){
		ArrayList<chitiethoadonbean> ds = new ArrayList<chitiethoadonbean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from chitiethoadon\r\n"
    				+ "where mahd=?;";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setLong(1, hdid);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			long macthd=rs.getLong("macthd");
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				long soluongmua=rs.getLong("soluongmua");
				long mahd=rs.getLong("mahd");
				boolean damua=rs.getBoolean("damua");
    			
				return new chitiethoadonbean(macthd, mamonan, tenmonan, soluongmua, mahd, damua) ;
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public chitiethoadonbean getNewMaHD() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select top 1 macthd, mahd , damua \r\n"
					+ "from chitiethoadon\r\n"
					+ "order by mahd desc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				// lay ve maloai a tenloai
				long macthd=rs.getLong("macthd");
				long mahd=rs.getLong("mahd");
				boolean damua=rs.getBoolean("damua");
				return new chitiethoadonbean(macthd,mahd,damua);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
