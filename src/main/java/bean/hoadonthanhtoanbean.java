package bean;

import java.util.Date;

public class hoadonthanhtoanbean {
	private String matk;
	private String tenmonan;
	private long gia;
	private long soluongmua;
	private long thanhtien; 
	private long mahd;
	private Date ngaymua;
	
	public hoadonthanhtoanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public hoadonthanhtoanbean(String matk, String tenmonan, long gia, long soluongmua, long thanhtien, long mahd,
			Date ngaymua) {
		super();
		this.matk = matk;
		this.tenmonan = tenmonan;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = thanhtien;
		this.mahd = mahd;
		this.ngaymua = ngaymua;
	}
	

	public hoadonthanhtoanbean(Date ngaymua) {
		super();
		this.ngaymua = ngaymua;
	}

	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public String getTenmonan() {
		return tenmonan;
	}
	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	
	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	@Override
	public String toString() {
		return "hoadonthanhtoanbean [matk=" + matk + ", tenmonan=" + tenmonan + ", gia=" + gia + ", soluongmua="
				+ soluongmua + ", thanhtien=" + thanhtien + ", mahd=" + mahd + ", ngaymua=" + ngaymua + "]";
	}
}
