package com.mycompany.ewalletproject.observables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.mycompany.ewalletproject.walletitems.Cash;
import com.mycompany.ewalletproject.walletitems.CreditCard;

import org.lecturestudio.avdev.AudioStream;


public class Observer implements IObserver{
    private ISubject obs;

    public Observer(ISubject obs){
       this.obs = obs;
       this.obs.attach(this);
    }

    public void update(IBalanceObservable bo){
        if(bo instanceof CreditCard){
            CreditCard cc = (CreditCard)bo;
            if(cc.getBalance() > (cc.getLimit()*0.5)){
                try{ 
                    makeSound();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("Balance is over half the limit");        
            }
        }
        else if(bo instanceof Cash){
            Cash c = (Cash)bo;
            if(c.getAmount()<30){
                try{ 
                    makeSound();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("Amount is less than $30"); 
            }
        }
        
    
    }
    public void makeSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File file = new File("./EWalletProject/src/main/java/com/mycompany/ewalletproject/observables/phone.wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        AudioFormat format = ais.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(ais);
        audioClip.start();
        ais.close();
    }
}
