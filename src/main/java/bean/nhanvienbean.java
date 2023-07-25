package bean;

import java.util.Date;

public class nhanvienbean {
	private long manv;
	private long matk;
	private String hotennv;
	private Date ngaysinh;
	private String noisinh;
	public nhanvienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhanvienbean(long manv, long matk, String hotennv, Date ngaysinh, String noisinh) {
		super();
		this.manv = manv;
		this.matk = matk;
		this.hotennv = hotennv;
		this.ngaysinh = ngaysinh;
		this.noisinh = noisinh;
	}
	public long getManv() {
		return manv;
	}
	public void setManv(long manv) {
		this.manv = manv;
	}
	public long getMatk() {
		return matk;
	}
	public void setMatk(long matk) {
		this.matk = matk;
	}
	public String getHotennv() {
		return hotennv;
	}
	public void setHotennv(String hotennv) {
		this.hotennv = hotennv;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getNoisinh() {
		return noisinh;
	}
	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}
	
	
	@Override
	public String toString() {
		return "nhanvienbean [manv=" + manv + ", matk=" + matk + ", hotennv=" + hotennv + ", ngaysinh=" + ngaysinh
				+ ", noisinh=" + noisinh + "]";
	}
}
