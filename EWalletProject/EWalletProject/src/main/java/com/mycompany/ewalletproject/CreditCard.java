package com.mycompany.ewalletproject;

public class CreditCard extends PaymentCard{
  private Date expiryDate;
  private String secCode;
  private double limit;

  public CreditCard(String cardName, String cardNumber, Date expiryDate, String secCode, double limit){
    super(cardName, cardNumber);
    this.expiryDate = expiryDate;
    this.secCode = secCode;
    this.limit = limit;
  }

  //Get Methods
  public Date getExpiryDate() {
    return expiryDate;
  }
  public String getSecCode() {
    return secCode;
  }
  public double getLimit(){
    return this.limit;
  }
  public String toString(){
      String repr = "\nDate: " + this.expiryDate + 
              " \nSecurity code: " + this.secCode + 
              " \nLimit:" + this.limit;
      return super.toString() + repr;
  }


}
