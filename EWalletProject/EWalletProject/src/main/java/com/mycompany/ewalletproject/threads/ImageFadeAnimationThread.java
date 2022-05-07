package com.mycompany.ewalletproject.threads;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ImageFadeAnimationThread extends Thread{
    private ImageView iv;
    public ImageFadeAnimationThread(ImageView iv){
        this.iv = iv;
    }
    // Creates a fade animation for an image
    @Override
    public void run(){
        this.animate();
    }
    public void animate(){
        FadeTransition fade = new FadeTransition();
        fade.setNode(this.iv);
        fade.setDuration(Duration.millis(1500));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setAutoReverse(true);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();  
    }
}
