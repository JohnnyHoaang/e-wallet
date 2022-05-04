package com.mycompany.ewalletproject.threads;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class GreetingThread extends Thread{
    private Text welcomeText;
    public GreetingThread(Text welcomeText){
        this.welcomeText = welcomeText;
    }
    @Override
    public void run(){
         greetingFade();
    }
    private void greetingFade(){
        FadeTransition fade = new FadeTransition();
        fade.setNode(this.welcomeText);
        fade.setDuration(Duration.millis(1500));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setAutoReverse(true);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play(); 
    }
}
