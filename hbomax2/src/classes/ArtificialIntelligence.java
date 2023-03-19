/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.dataStructures.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac
 */
public class ArtificialIntelligence extends Thread {

    final Administrator administrator;

    Chapter chapterRm;
    Chapter chapterTlou;

    int runTime;

    final Random r = new Random();

    public ArtificialIntelligence(Administrator administrator) {
        this.administrator = administrator;

        int runTimeSeconds = 6 + 0 + 9 + 1 + 10;
        this.runTime = runTimeSeconds * 1000;
    }

    @Override
    public void run() {
        try {
            // null safety check
            if (this.chapterRm == null || this.chapterTlou == null) {
                this.administrator.returnChaptersToQueue(this.chapterRm, this.chapterTlou);
                Thread.sleep(this.runTime);
            } else {
                int result = r.nextInt(100);

                Thread.sleep(this.runTime / 6);

                // select a winner
                if (result <= 40) { // 40%
                    Chapter winner;

                    Thread.sleep(3 * this.runTime / 6);

                    // TODO: RULETA
                    int selector = r.nextInt(100);
                    if (selector <= 50) {
                        winner = this.chapterRm;
                    } else {
                        winner = this.chapterTlou;
                    }

                    Thread.sleep(this.runTime / 6);

                    this.administrator.saveChapterToTxt(winner);

                } 
                // return chapters to its queue
                else if (result <= 67) { // 27%
                    Thread.sleep(4 * this.runTime / 6);
                    this.administrator.returnChaptersToQueue(this.chapterRm, this.chapterTlou);
                } 
                // send chapters to booster queue
                else { // 33%
                    Thread.sleep(4 * this.runTime / 6);
                    this.administrator.sendChaptersToBoosterQueue(this.chapterRm, this.chapterTlou);
                }

                Thread.sleep(this.runTime / 6);
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

}
