package com.mycompany.ewalletproject.threads;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class MakeWarningSoundThread extends Thread{
    // makes a sound when called
    @Override
    public void run(){
        this.warn();
    }
    public void warn(){
        try {
            File file = new File("./src/main/java/com/mycompany/ewalletproject/sound/phonebrrr.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(ais);
            audioClip.start();
            ais.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
