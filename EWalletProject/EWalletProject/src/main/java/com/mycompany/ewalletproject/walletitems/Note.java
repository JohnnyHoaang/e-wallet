package com.mycompany.ewalletproject.walletitems;

import com.mycompany.ewalletproject.threads.MakeWarningSoundThread;

import javafx.application.Platform;

public class Note implements IWalletItem{
  private CustomDate creationDate;
  private String text;
  private long reminderFrequency;
  private static int sequenceNum = 0;
  private int id;
  
  // Default constructor
  public Note(CustomDate creationDate, String text) {
    this.creationDate = creationDate;
    this.text = text;
    this.id = sequenceNum++;
  }
  
  //Get and Set Methods
  public CustomDate getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(CustomDate creationDate) {
    this.creationDate = creationDate;
  }


  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  public long getReminderFrequency() {
    return reminderFrequency;
  }
  public void setReminderFrequency(long reminderFrequency) {
    this.reminderFrequency = reminderFrequency;
  }
  // Reminds user that there is a note
  public void remind() throws InterruptedException{
    while(true){
    Thread.sleep(this.getReminderFrequency());
    Thread makeSoundThread = new MakeWarningSoundThread();
    Platform.runLater(makeSoundThread);
    }
  }

  public int getID(){
    return this.id;
  }

  public void setID(int id){
    this.id = id;
  }

  public String toString(){
    String information = "Text: " + this.text 
                        + "\nCreation date: " + this.creationDate 
                        + "\nID: " + this.id ;
    return "Note: \n" + information;
  }
}
