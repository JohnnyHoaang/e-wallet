package com.mycompany.ewalletproject.walletitems;
import java.sql.Date;

public class CustomDate {
  private String date;
  // Default constructor
  public CustomDate(String date){
      this.date = date;
  }
  public Date formatDateToSQL(){
    Date date = Date.valueOf(this.reformatDateString());
    return date;
  }
  private String reformatDateString(){
    String [] dates = this.date.split("/");
    String year = "";
    int numYear = Integer.parseInt(dates[1]);
    if ( numYear > 25 && numYear < 100){
      year = "19"+dates[1];
    } else if (numYear>99){
      throw new IllegalArgumentException("Year is not valid");
    }
    else {
      year = "20"+dates[1];
    }
    String month = dates[0];
    final String DAY = "1";
    return year+"-"+month+"-"+DAY;
  }
  public String toString(){
      return this.date;
  }
}
