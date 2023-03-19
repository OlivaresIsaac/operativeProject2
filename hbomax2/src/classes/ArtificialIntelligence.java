/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.dataStructures.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.GlobalUI;
import ui.UiRing;

/**
 *
 * @author isaac
 */
public class ArtificialIntelligence extends Thread {

    final Administrator administrator;
    boolean emulatorRunning = true;

    Chapter chapterRm;
    Chapter chapterTlou;

    int runTime;

    final Random r = new Random();
    
    public Semaphore mutex;
    
    public UiRing rmRing = GlobalUI.getMainPage().getUiRingRm();
    public UiRing tlouRing = GlobalUI.getMainPage().getUiRingTlou();
    

    public ArtificialIntelligence() {
        this.administrator = Main.operativeSystem;

//        int runTimeSeconds = 6 + 0 + 9 + 1 + 10;
        int runTimeSeconds = 3;
        this.runTime = runTimeSeconds * 1000;
        this.mutex = Main.mutex;
    }

    @Override
    public void run() {
        try {
            // null safety check
            while (this.emulatorRunning) {
               
                this.mutex.acquire();
                
                if (this.chapterRm == null || this.chapterTlou == null) {
                this.administrator.returnChaptersToQueue(this.chapterRm, this.chapterTlou);
                Thread.sleep(this.runTime);
                
                
            } else {
                updateUiRing();
                GlobalUI.getMainPage().setStatusLabel("Decidiendo...");
                int result = r.nextInt(100);

                Thread.sleep(this.runTime / 6);

                // select a winner
                if (result <= 40) { // 40%
                    Chapter winner;
                    
                    Thread.sleep(3 * this.runTime / 6);
                    GlobalUI.getMainPage().setStatusLabel("Ganador!");
                    // TODO: RULETA
                    int selector = r.nextInt(100);
                    if (selector <= 50) {
                        winner = this.chapterRm;
                        this.rmRing.setWinner();
                    } else {
                        winner = this.chapterTlou;
                        this.tlouRing.setWinner();
                    }

                    Thread.sleep(this.runTime / 6);

                    this.administrator.saveChapterToTxt(winner);

                } 
                // return chapters to its queue
                else if (result <= 67) { // 27%
                    GlobalUI.getMainPage().setStatusLabel("Empate");
                    Thread.sleep(4 * this.runTime / 6);
                    this.administrator.returnChaptersToQueue(this.chapterRm, this.chapterTlou);
                } 
                // send chapters to booster queue
                else { // 33%
                    GlobalUI.getMainPage().setStatusLabel("Reforzar");
                    Thread.sleep(4 * this.runTime / 6);
                    this.administrator.sendChaptersToBoosterQueue(this.chapterRm, this.chapterTlou);
                }

                Thread.sleep(this.runTime / 6);
                
                }
                GlobalUI.getMainPage().setStatusLabel("Esperando");
                this.mutex.release();
                Thread.sleep(100);
            }
            
           

        } catch (InterruptedException ex) {
            Logger.getLogger(ArtificialIntelligence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public void setChapterRm(Chapter chapterRm) {
        this.chapterRm = chapterRm;
    }

    public void setChapterTlou(Chapter chapterTlou) {
        this.chapterTlou = chapterTlou;
    }
    
    public void updateUiRing(){
        this.rmRing.updateRing(this.chapterRm);
        this.tlouRing.updateRing(this.chapterTlou);
    }

}
