package bean;
/**
 * @author liuleilei liuleilei2015@gmail.com
 * @date 2018年1月14日 下午8:46:24
 * @Description: TODO
 */

import java.sql.Timestamp;

public class SubscribeBean {
	private String CID;
	private String Ctype;
	private String Cplatenum;
	private Timestamp Book_date;
	private Timestamp Rent_date;
	private Timestamp Back_date;
	
	public SubscribeBean(String cID, String ctype, String cplatenum, Timestamp book_date, Timestamp rent_date,
			Timestamp back_date) {
		super();
		CID = cID;
		Ctype = ctype;
		Cplatenum = cplatenum;
		Book_date = book_date;
		Rent_date = rent_date;
		Back_date = back_date;
	}
	public SubscribeBean() {}
	
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCtype() {
		return Ctype;
	}
	public void setCtype(String ctype) {
		Ctype = ctype;
	}
	public String getCplatenum() {
		return Cplatenum;
	}
	public void setCplatenum(String cplatenum) {
		Cplatenum = cplatenum;
	}
	public Timestamp getBook_date() {
		return Book_date;
	}
	public void setBook_date(Timestamp book_date) {
		Book_date = book_date;
	}
	public Timestamp getRent_date() {
		return Rent_date;
	}
	public void setRent_date(Timestamp rent_date) {
		Rent_date = rent_date;
	}
	public Timestamp getBack_date() {
		return Back_date;
	}
	public void setBack_date(Timestamp back_date) {
		Back_date = back_date;
	}
}
