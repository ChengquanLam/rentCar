package bean;
/**
 * @author liuleilei liuleilei2015@gmail.com
 * @date 2018年1月14日 下午8:24:40
 * @Description: TODO
 */
public class CarBean {
	private String Cplatenum;
	private String Ctype;
	private String Cpurdate;
	private String Ccondition;
	
	public CarBean(String cplatenum, String ctype, String cpurdate, String ccondition) {
		super();
		Cplatenum = cplatenum;
		Ctype = ctype;
		Cpurdate = cpurdate;
		Ccondition = ccondition;
	}
	public CarBean() {}
	
	public String getCplatenum() {
		return Cplatenum;
	}
	public void setCplatenum(String cplatenum) {
		Cplatenum = cplatenum;
	}
	public String getCtype() {
		return Ctype;
	}
	public void setCtype(String ctype) {
		Ctype = ctype;
	}
	public String getCpurdate() {
		return Cpurdate;
	}
	public void setCpurdate(String cpurdate) {
		Cpurdate = cpurdate;
	}
	public String getCcondition() {
		return Ccondition;
	}
	public void setCcondition(String ccondition) {
		Ccondition = ccondition;
	}
}
