package bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

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
		/*
		 * public String KHmuanhieunhat() { return hdttdao.KHmuanhieunhat(); }
		 */
	   
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
	   
	   public int getTotalHDByDate(Date ngaymua) {
			return hdttdao.getTotalHDByDate(ngaymua);
		}

		public ArrayList<hoadonthanhtoanbean> pagingHD(int index, Date ngay) {
			return hdttdao.pagingHD(index, ngay);
		}
	   
		public ArrayList<hoadonthanhtoanbean> getHDByDate(Date ngay){
			return hdttdao.getHDByDate(ngay);
		}
		
		public ArrayList<hoadonthanhtoanbean> getNgay(){
			return hdttdao.getNgay();
		}
	   public static void main(String[] args) throws ParseException {
		  hoadonthanhtoanbo hdtt = new hoadonthanhtoanbo();
			
			  String ngay = "2023-07-13"; Date date = Date.valueOf(ngay);
			  
				/*
				 * ArrayList<hoadonthanhtoanbean> hd = hdtt.getNgay(); for(hoadonthanhtoanbean s
				 * : hd) { System.out.println(s); }
				 */
			 
	}
}
