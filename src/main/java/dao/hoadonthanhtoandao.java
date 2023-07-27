package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import bean.hoadonthanhtoanbean;
import bean.monanbean;
import bean.taikhoanbean;

public class hoadonthanhtoandao {
	public ArrayList<hoadonthanhtoanbean> HienThi(long hdid) {
		ArrayList<hoadonthanhtoanbean> ds = new ArrayList<hoadonthanhtoanbean>();
		try {
			// B1: ket noi vao csdl QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			// B2: lay du lieu ve
			String sql = "select * from viewhoadonthanhtoan where mahd=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, hdid);
			ResultSet rs = cmd.executeQuery();

			// B3: Duyet rs de luu vao
			while (rs.next()) {
				// lay ve maloai a tenloai
				String matk = rs.getString("matk");
				String tenmonan = rs.getString("tenmonan");
				long soluongmua = rs.getLong("soluongmua");
				long gia = rs.getLong("gia");
				long thanhtien = rs.getLong("thanhtien");
				long mahd = rs.getLong("mahd");
				boolean damua = rs.getBoolean("damua");
				Date ngaymua = rs.getDate("ngaymua");
				ds.add(new bean.hoadonthanhtoanbean(matk, tenmonan, gia, soluongmua, thanhtien, mahd, ngaymua));
			}

			// B4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public long Tongtienthongke() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select sum(thanhtien)\r\n" + "from viewhoadonthanhtoan\r\n" + "where damua = 1";

			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * public String KHmuanhieunhat() { try { KetNoi kn = new KetNoi(); kn.KetNoi();
	 * String sql = "select viewhoadonthanhtoan.matk, tendn, sum(soluongmua)\r\n" +
	 * "from viewhoadonthanhtoan join taikhoan\r\n" +
	 * "on viewhoadonthanhtoan.matk = taikhoan.matk\r\n" + "where damua = 1\r\n" +
	 * "group by viewhoadonthanhtoan.matk, tendn\r\n" +
	 * "having sum(soluongmua) >= all (\r\n" +
	 * "									select sum(soluongmua)\r\n" +
	 * "									from viewhoadonthanhtoan join taikhoan\r\n"
	 * +
	 * "									on viewhoadonthanhtoan.matk = taikhoan.matk\r\n"
	 * + "									where damua = 1\r\n" +
	 * "									group by viewhoadonthanhtoan.matk, tendn\r\n"
	 * + "\r\n" + ")";
	 * 
	 * PreparedStatement cmd = kn.cn.prepareStatement(sql); ResultSet rs =
	 * cmd.executeQuery(); while (rs.next()) { return rs.getString(2); } } catch
	 * (Exception e) { e.printStackTrace(); } return null; }
	 */

	public long Slhoadonbanduoc() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select count(*)\r\n" + "from viewhoadonthanhtoan\r\n" + "where damua = 1;";

			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public hoadonthanhtoanbean getNgaymua(long hdid) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select DISTINCT ngaymua\r\n" + "from viewhoadonthanhtoan\r\n" + "where mahd = ?";

			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, hdid);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Date ngaymua = rs.getDate("ngaymua");
				return new hoadonthanhtoanbean(ngaymua);
			}
			rs.close();
			kn.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<hoadonthanhtoanbean> HienThiHDALL() {
		ArrayList<hoadonthanhtoanbean> ds = new ArrayList<hoadonthanhtoanbean>();
		try {
			// B1: ket noi vao csdl QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			// B2: lay du lieu ve
			String sql = "select mahd, matk, tenmonan, gia, soluongmua, thanhtien, damua, ngaymua\r\n"
					+ "from viewhoadonthanhtoan\r\n" + "order by mahd desc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			// B3: Duyet rs de luu vao
			while (rs.next()) {
				long mahd = rs.getLong("mahd");
				String matk = rs.getString("matk");
				String tenmonan = rs.getString("tenmonan");
				long gia = rs.getLong("gia");
				long soluongmua = rs.getLong("soluongmua");
				long thanhtien = rs.getLong("thanhtien");
				boolean damua = rs.getBoolean("damua");
				Date ngaymua = rs.getDate("ngaymua");
				ds.add(new bean.hoadonthanhtoanbean(matk, tenmonan, gia, soluongmua, thanhtien, mahd, ngaymua));
			}

			// B4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getTotalHDByDate(Date ngaymua) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select count(*) from viewhoadonthanhtoan\r\n"
					+ "where ngaymua = ?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setDate(1, (java.sql.Date) ngaymua);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<hoadonthanhtoanbean> pagingHD(int index , Date ngay) {
		ArrayList<hoadonthanhtoanbean> list = new ArrayList<hoadonthanhtoanbean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select * from viewhoadonthanhtoan \r\n"
					+ "where ngaymua = ?\r\n"
					+ "order by mahd \r\n"
					+ "offset ? rows fetch next 6 rows only";

			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setDate(1, (java.sql.Date) ngay);
			cmd.setInt(2, (index - 1) * 6);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				long mahd = rs.getLong("mahd");
				String matk = rs.getString("matk");
				String tenmonan = rs.getString("tenmonan");
				long gia = rs.getLong("gia");
				long soluongmua = rs.getLong("soluongmua");
				long thanhtien = rs.getLong("thanhtien");
				boolean damua = rs.getBoolean("damua");
				Date ngaymua = rs.getDate("ngaymua");
				list.add(new bean.hoadonthanhtoanbean(matk, tenmonan, gia, soluongmua, thanhtien, mahd, ngaymua));
			}
			rs.close();
			kn.cn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public ArrayList<hoadonthanhtoanbean> getHDByDate(Date ngay){
		ArrayList<hoadonthanhtoanbean> ds = new ArrayList<hoadonthanhtoanbean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select * \r\n"
					+ "from viewhoadonthanhtoan\r\n"
					+ "where ngaymua = ?";

			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setDate(1, (java.sql.Date) ngay);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String matk = rs.getString("matk");
				String tenmonan = rs.getString("tenmonan");
				long gia = rs.getLong("gia");
				long soluongmua = rs.getLong("soluongmua");
				long thanhtien = rs.getLong("thanhtien");
				long mahd = rs.getLong("mahd");
				boolean damua = rs.getBoolean("damua");
				Date ngaymua = rs.getDate("ngaymua");
				
				ds.add(new hoadonthanhtoanbean(matk, tenmonan, gia, soluongmua, thanhtien, mahd, ngaymua));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
	public ArrayList<hoadonthanhtoanbean> getNgay(){
		ArrayList<hoadonthanhtoanbean> ds = new ArrayList<hoadonthanhtoanbean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select distinct top 31 ngaymua\r\n"
					+ "from viewhoadonthanhtoan\r\n"
					+ "order by ngaymua desc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			// lay ve maloai a tenloai
				Date ngaymua = rs.getDate("ngaymua");
				ds.add(new hoadonthanhtoanbean(ngaymua));
    		}
    		return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public static void main(String[] args) {
		hoadonthanhtoandao hd = new hoadonthanhtoandao();
		String ngay = "2022-07-13";
		Date date = Date.valueOf(ngay);
		ArrayList<hoadonthanhtoanbean> ds = hd.pagingHD(2, date);
		for(hoadonthanhtoanbean s : ds) {
			System.out.println(s);
		}
	}
}
