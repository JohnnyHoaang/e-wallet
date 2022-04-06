package com.mycompany.ewalletproject;

public class RemindThread extends Thread {
    private Note note;

    public RemindThread(Note note){
        this.note = note;
    }
    @Override
    public void run(){
        try {
            this.note.remind();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}