package com.mycompany.ewalletproject;

public class Note implements IWalletItem{
  private Date creationDate;
  private String text;
  private boolean reminder = false;
  private long reminderFrequency;
  private int id;
  
  public Note(Date creationDate, String text) {
    this.creationDate = creationDate;
    this.text = text;
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
    // make sound
    }
  }

  public int getID(){
    return this.id;
  }
}
