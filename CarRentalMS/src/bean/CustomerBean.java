package bean;

import java.sql.Timestamp;

/**
 * @author liuleilei liuleilei2015@gmail.com
 * @date 2018年1月14日 下午8:32:24
 * @Description: TODO
 */
public class CustomerBean {
	private String CID;
	private String Cname;
	private String WorkAddress;
	private String Tell;
	private Timestamp FirstDate;
	
	public CustomerBean(String cID, String cname, String workAddress, String tell, Timestamp firstDate) {
		super();
		CID = cID;
		Cname = cname;
		WorkAddress = workAddress;
		Tell = tell;
		FirstDate = firstDate;
	}
	public CustomerBean() {}
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getWorkAddress() {
		return WorkAddress;
	}
	public void setWorkAddress(String workAddress) {
		WorkAddress = workAddress;
	}
	public String getTell() {
		return Tell;
	}
	public void setTell(String tell) {
		Tell = tell;
	}
	public Timestamp getFirstDate() {
		return FirstDate;
	}
	public void setFirstDate(Timestamp firstDate) {
		FirstDate = firstDate;
	}
}
