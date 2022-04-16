package com.mycompany.ewalletproject.threads;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MakeWarningSoundThread extends Thread{
    @Override
    public void run(){
        try {
            File file = new File("./EWalletProject/src/main/java/com/mycompany/ewalletproject/sound/phone.wav");
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
