
package bean;

public class thongkebean {
	private String tenmonan;
	private String anh;
	private long gia;
	private long tongslmua;

	public thongkebean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public thongkebean(String tenmonan, String anh, long gia, long tongslmua) {
		super();
		this.tenmonan = tenmonan;
		this.anh = anh;
		this.gia = gia;
		this.tongslmua = tongslmua;
	}

	public String getTenmonan() {
		return tenmonan;
	}

	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getTongslmua() {
		return tongslmua;
	}

	public void setTongslmua(long tongslmua) {
		this.tongslmua = tongslmua;
	}

	@Override
	public String toString() {
		return "thongkebean [tenmonan=" + tenmonan + ", anh=" + anh + ", gia=" + gia + ", tongslmua=" + tongslmua + "]";
	}

}
