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

    int runTime;

    final Random r = new Random();

    public ArtificialIntelligence(Administrator administrator) {
        this.administrator = administrator;

        int runTimeSeconds = 6 + 0 + 9 + 1 + 10;
        this.runTime = runTimeSeconds * 1000;
    }

    public void run(Chapter chapterRm, Chapter chapterTlou) {
        try {
            int result = r.nextInt(100);

            if (result <= 40) { // 40%
                Chapter winner;

                // Random to find who won 50/50
                int selector = r.nextInt(100);
                if (selector <= 50) {
                    winner = chapterRm;
                } else {
                    winner = chapterTlou;
                }

                this.administrator.saveChapterToTxt(winner);

            } else if (result <= 67) { // 27%
                this.administrator.returnChaptersToQueue(chapterRm, chapterTlou);
            } else { // 33%
                this.administrator.sendChaptersToBoosterQueue(chapterRm, chapterTlou);
            }
            Thread.sleep(this.runTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArtificialIntelligence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

}
