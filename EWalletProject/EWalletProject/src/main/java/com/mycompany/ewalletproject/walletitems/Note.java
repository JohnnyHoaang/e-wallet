package com.mycompany.ewalletproject.walletitems;

public class Note implements IWalletItem{
  private Date creationDate;
  private String text;
  private boolean reminder = false;
  private long reminderFrequency;
  private static int sequenceNum = 0;
  private int id;
  
  public Note(Date creationDate, String text) {
    this.creationDate = creationDate;
    this.text = text;
    this.id = sequenceNum++;
  }
  
  //Get and Set Methods
  public Date getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }


  public boolean isReminder() {
    return reminder;
  }
  public void setReminder(boolean reminder){
    this.reminder = reminder;
  }


  public long getReminderFrequency() {
    return reminderFrequency;
  }
  public void setReminderFrequency(long reminderFrequency) {
    this.reminderFrequency = reminderFrequency;
  }

  public void remind() throws InterruptedException{
    while(true){
    Thread.sleep(this.getReminderFrequency());
    System.out.println("Reminding!");
    }
  }

  public int getID(){
    return this.id;
  }

  public String toString(){
    String information = "Text: " + this.text 
                        + "\nCreation date: " + this.creationDate 
                        + "\nID: " + this.id ;
    return information;
  }
}
