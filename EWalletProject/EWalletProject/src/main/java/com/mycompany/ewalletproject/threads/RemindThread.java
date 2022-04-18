package com.mycompany.ewalletproject.threads;

import com.mycompany.ewalletproject.walletitems.Note;

public class RemindThread extends Thread{
  private Note note;
  public RemindThread(Note note){
    this.note = note;
  }
  // Reminds user 
  @Override
  public void run(){
    try {
      this.note.remind();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
