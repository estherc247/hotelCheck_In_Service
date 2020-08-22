package oodp;



public class CreditCard {
	private long cardNo;
	private String expiryDate;
	private int cCV;
	public CreditCard() {
	}
	public CreditCard(long cardNo, String expiryDate, int cCV) {
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		this.cCV = cCV;
		
	
	}
	public void setCardNo(long cardNo) {
		this.cardNo= cardNo; }
	public void setExpiryDate(String expiryDate) {
		this.expiryDate= expiryDate; }
	public void setCCV(int cCV) {
		this.cCV= cCV; }
	
	public long getCardNo(){
		return cardNo;
		}
	public String getExpiryDate(){
		return expiryDate;
		}
	public int getCCV(){
		return cCV;
		}
	
}
