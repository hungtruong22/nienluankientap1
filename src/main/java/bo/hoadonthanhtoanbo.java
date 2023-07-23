package bo;

import java.util.ArrayList;

import bean.giohangbean;
import bean.hoadonthanhtoanbean;
import bean.taikhoanbean;
import dao.hoadonthanhtoandao;

public class hoadonthanhtoanbo {
	hoadonthanhtoandao hdttdao= new hoadonthanhtoandao();
	   ArrayList<hoadonthanhtoanbean> ds;
	   public ArrayList<hoadonthanhtoanbean> HienThi(long hdid){
		   return hdttdao.HienThi(hdid);
	   }
	   public String KHmuanhieunhat() {
		   return hdttdao.KHmuanhieunhat();
	   }
	   
	   public long Tongtienthongke() {
		   return hdttdao.Tongtienthongke();
	   }
	   public long Slhoadonbanduoc() {
		   return hdttdao.Slhoadonbanduoc();
	   }
	   public hoadonthanhtoanbean getNgaymua(long hdid) {
		   return hdttdao.getNgaymua(hdid);
	   }	
	   
	   public ArrayList<hoadonthanhtoanbean> HienThiHDALL(){
		   return hdttdao.HienThiHDALL();
	   }
	   
	   public int getTotalHD() {
			return hdttdao.getTotalHD();
		}

		public ArrayList<hoadonthanhtoanbean> pagingHD(int index) {
			return hdttdao.pagingHD(index);
		}
	   
	   public static void main(String[] args) {
		  hoadonthanhtoanbo lsbo = new hoadonthanhtoanbo();
		  
	}
}
