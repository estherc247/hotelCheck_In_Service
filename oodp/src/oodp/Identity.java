package oodp;



public class Identity {
	private String iDType;
	private String iDNo;
	public Identity() {
	}
	public Identity(String iDType, String iDNo) {
		this.iDType = iDType;
		this.iDNo = iDNo;
	}
	public void setIDType(String iDType) {this.iDType = iDType;}
	public void setIDNo(String iDNo) {this.iDNo = iDNo;}
	
	public String getIDType() {return iDType;}
	public String getIDNo() {return iDNo;}
}
