package bean;
/**
 * @author liuleilei liuleilei2015@gmail.com
 * @date 2018年1月14日 下午8:29:48
 * @Description: TODO
 */
public class CarTypeBean {
	private String Ctype;
	private double Drent;
	private double Mrent;
	
	public CarTypeBean(String ctype, double drent, double mrent) {
		super();
		Ctype = ctype;
		Drent = drent;
		Mrent = mrent;
	}
	public CarTypeBean() {}
	
	public String getCtype() {
		return Ctype;
	}
	public void setCtype(String ctype) {
		Ctype = ctype;
	}
	public double getDrent() {
		return Drent;
	}
	public void setDrent(double drent) {
		Drent = drent;
	}
	public double getMrent() {
		return Mrent;
	}
	public void setMrent(double mrent) {
		Mrent = mrent;
	}
}
