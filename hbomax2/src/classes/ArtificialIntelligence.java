/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac
 */
public class ArtificialIntelligence extends Thread {

    final int runTime;
    final Chapter chapterRm;
    final Chapter chapterTlou;

    final Random r = new Random();

    public ArtificialIntelligence(Chapter chapterRm, Chapter chapterTlou) {
        int runTimeSeconds = 6 + 0 + 9 + 1 + 10;
        
        this.runTime = runTimeSeconds * 1000;
        this.chapterRm = chapterRm;
        this.chapterTlou = chapterTlou;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int result = r.nextInt(100);

                if (result < 40) { // 40%
                    // do something
                } else if (result < 67) { // 27%
                    // do something
                } else { // 33%
                    // do something
                }

                Thread.sleep(this.runTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(ArtificialIntelligence.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
