package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hoadonthanhtoanbean;
import bean.thongkebean;

public class thongkedao {
	public ArrayList<thongkebean> dssuabanchay() {
		ArrayList<thongkebean> dssuabanchay = new ArrayList<thongkebean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select viewhoadonthanhtoan.tenmonan, monan.anh , monan.gia, sum(soluongmua)\r\n"
					+ "from viewhoadonthanhtoan join monan\r\n"
					+ "on viewhoadonthanhtoan.tenmonan = monan.tenmonan\r\n"
					+ "where damua = 1\r\n" 
					+ "group by viewhoadonthanhtoan.tenmonan, monan.anh, monan.gia\r\n"
					+ "having sum(soluongmua) >= all (\r\n"
					+ "								select sum(soluongmua)\r\n"
					+ "								from viewhoadonthanhtoan join monan\r\n"
					+ "								on viewhoadonthanhtoan.tenmonan = monan.tenmonan\r\n"
					+ "								where damua = 1\r\n"
					+ "								group by viewhoadonthanhtoan.tenmonan\r\n"
					+ ")";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tenmonan = rs.getString(1);
				String anh = rs.getString(2);
				long gia = rs.getLong(3);
				long tongslmua = rs.getLong(4);
				dssuabanchay.add(new thongkebean(tenmonan, anh, gia, tongslmua));
			}

			rs.close();
			kn.cn.close();
			return dssuabanchay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<thongkebean> dssuabancham() {
		ArrayList<thongkebean> dssuabancham = new ArrayList<thongkebean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			String sql = "select viewhoadonthanhtoan.tenmonan, monan.anh , monan.gia, sum(soluongmua)\r\n"
					+ "from viewhoadonthanhtoan join monan\r\n"
					+ "on viewhoadonthanhtoan.tenmonan = monan.tenmonan\r\n"
					+ "where damua = 1\r\n"
					+ "group by viewhoadonthanhtoan.tenmonan, monan.anh, monan.gia\r\n"
					+ "having sum(soluongmua) <= all (\r\n"
					+ "								select sum(soluongmua)\r\n"
					+ "								from viewhoadonthanhtoan join monan\r\n"
					+ "								on viewhoadonthanhtoan.tenmonan = monan.tenmonan\r\n"
					+ "								where damua = 1\r\n"
					+ "								group by viewhoadonthanhtoan.tenmonan\r\n"
					+ ")";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tenmonan = rs.getString(1);
				String anh = rs.getString(2);
				long gia = rs.getLong(3);
				long tongslmua = rs.getLong(4);
				dssuabancham.add(new thongkebean(tenmonan, anh, gia, tongslmua));
			}

			rs.close();
			kn.cn.close();
			return dssuabancham;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		thongkedao tk = new thongkedao();
	}
}
