package bean;
/**
 * @author liuleilei liuleilei2015@gmail.com
 * @date 2018年1月14日 下午8:40:44
 * @Description: TODO
 */

import java.sql.Timestamp;

public class RentBean {
	private String CID;
	private String Cplatenum;
	private String RentType;
	private Timestamp SubBack_date;
	private double SubRent;
	private double Deposit;
	private Timestamp Back_date;
	private double Rent;
	
	public RentBean(String cID, String cplatenum, String rentType, Timestamp subBack_date, double subRent,
			double deposit, Timestamp back_date, double rent) {
		super();
		CID = cID;
		Cplatenum = cplatenum;
		RentType = rentType;
		SubBack_date = subBack_date;
		SubRent = subRent;
		Deposit = deposit;
		Back_date = back_date;
		Rent = rent;
	}
	public RentBean() {}
	
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCplatenum() {
		return Cplatenum;
	}
	public void setCplatenum(String cplatenum) {
		Cplatenum = cplatenum;
	}
	public String getRentType() {
		return RentType;
	}
	public void setRentType(String rentType) {
		RentType = rentType;
	}
	public Timestamp getSubBack_date() {
		return SubBack_date;
	}
	public void setSubBack_date(Timestamp subBack_date) {
		SubBack_date = subBack_date;
	}
	public double getSubRent() {
		return SubRent;
	}
	public void setSubRent(double subRent) {
		SubRent = subRent;
	}
	public double getDeposit() {
		return Deposit;
	}
	public void setDeposit(double deposit) {
		Deposit = deposit;
	}
	public Timestamp getBack_date() {
		return Back_date;
	}
	public void setBack_date(Timestamp back_date) {
		Back_date = back_date;
	}
	public double getRent() {
		return Rent;
	}
	public void setRent(double rent) {
		Rent = rent;
	}
	
	public String toString() {
		return CID+Cplatenum+RentType+SubBack_date+SubRent+Back_date+Rent;
	}
}
