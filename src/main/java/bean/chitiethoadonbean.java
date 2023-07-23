package bean;

public class chitiethoadonbean {
	private long macthd;
	private String mamonan;
	private String tenmonan;
	private long soluongmua;
	private long mahd;
	private boolean damua;
	public chitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitiethoadonbean(long macthd, String mamonan, String tenmonan, long soluongmua, long mahd, boolean damua) {
		super();
		this.macthd = macthd;
		this.mamonan = mamonan;
		this.tenmonan = tenmonan;
		this.soluongmua = soluongmua;
		this.mahd = mahd;
		this.damua = damua;
	}
	
	public chitiethoadonbean(long macthd, long mahd, boolean damua) {
		super();
		this.macthd = macthd;
		this.mahd = mahd;
		this.damua = damua;
	}
	public long getMacthd() {
		return macthd;
	}
	public void setMacthd(long macthd) {
		this.macthd = macthd;
	}
	public String getMamonan() {
		return mamonan;
	}
	public void setMamonan(String mamonan) {
		this.mamonan = mamonan;
	}
	public String getTenmonan() {
		return tenmonan;
	}
	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	@Override
	public String toString() {
		return "chitiethoadonbean [macthd=" + macthd + ", mamonan=" + mamonan + ", tenmonan=" + tenmonan
				+ ", soluongmua=" + soluongmua + ", mahd=" + mahd + ", damua=" + damua + "]";
	}	
}
