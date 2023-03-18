/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.dataStructures.Queue;
import java.util.Random;
import ui.GlobalUI;
import ui.UiQueue;

/**
 *
 * @author isaac
 */
public class Administrator {

    int counter = 0;

    public UiQueue uiQueueRm1;
    public Queue queueRm1;

    public UiQueue uiQueueRm2;
    public Queue queueRm2;

    public UiQueue uiQueueRm3;
    public Queue queueRm3;

    public UiQueue uiQueueRmBooster;
    public Queue queueRmBooster;

    public UiQueue uiQueueTlou1;
    public Queue queueTlou1;

    public UiQueue uiQueueTlou2;
    public Queue queueTlou2;

    public UiQueue uiQueueTlou3;
    public Queue queueTlou3;

    public UiQueue uiQueueTlouBooster;
    public Queue queueTlouBooster;

    final Random r = new Random();

    public Administrator() {
        createQueues();
    }

    /**
     * Creates all priority queues and gets the reference of all uiQueues
     */
    private void createQueues() {
        this.uiQueueRm1 = GlobalUI.getMainPage().getUiQueueRm1();
        this.queueRm1 = new Queue();

        this.uiQueueRm2 = GlobalUI.getMainPage().getUiQueueRm2();
        this.queueRm2 = new Queue();

        this.uiQueueRm3 = GlobalUI.getMainPage().getUiQueueRm3();
        this.queueRm3 = new Queue();

        this.uiQueueRmBooster = GlobalUI.getMainPage().getUiQueueRmBooster();
        this.queueRmBooster = new Queue();

        this.uiQueueTlou1 = GlobalUI.getMainPage().getUiQueueTlou1();
        this.queueTlou1 = new Queue();

        this.uiQueueTlou2 = GlobalUI.getMainPage().getUiQueueTlou2();
        this.queueTlou2 = new Queue();

        this.uiQueueTlou3 = GlobalUI.getMainPage().getUiQueueTlou3();
        this.queueTlou3 = new Queue();

        this.uiQueueTlouBooster = GlobalUI.getMainPage().getUiQueueTlouBooster();
        this.queueTlouBooster = new Queue();
    }

    public void startEmulator() {
        // TODO: add a chapter to each plant
        ArtificialIntelligence ia = new ArtificialIntelligence(this);
        while (true) {
            this.tryToReturnBoosterChapter();
            
            if (this.counter >= 2) {
                this.addNewChapter();
                this.setCounter(0);
            }
            
            Chapter chapterRm = this.getChapterFromQueues(this.queueRm1, this.queueRm2, this.queueRm3);
            Chapter chapterTlou = this.getChapterFromQueues(this.queueTlou1, this.queueTlou2, this.queueTlou3);
            
            chapterRm.setCounter(0);
            chapterTlou.setCounter(0);
            
            ia.run(chapterRm, chapterTlou);
            
            // TODO: sum chapters counter +1
        }
    }

    //TODO
    private void addNewChapter() {
        int result = r.nextInt(100);
        if (result <= 70) {
            // TODO: add a new series to the queue of its corresponding level
        }
    }
    
    //TODO
    private void tryToReturnBoosterChapter() {
        int result = r.nextInt(100);
        if (result <= 40) {
            // TODO: change chapter priority to 1
            // TODO: return booter chapter to its queue
        } else {
            // TODO: put the chapter at the end of the queue
        }
    }
    
    //TODO
    private Chapter getChapterFromQueues(Queue queue1, Queue queue2, Queue queue3) {
        //TODO: review all lists and return a chapter
        return null;
    }

    public void testQueue() {
        for (int i = 0; i < 30; i++) {
            Chapter test = new Chapter(i, "tlou");
            this.queueRm1.enqueue(test);
        }
        this.uiQueueTlouBooster.updateUiQueue(this.queueRm1);
    }

    public void saveChapterToTxt(Chapter chapter) {
        // Save Chapter To Txt
    }

    public void sendChaptersToBoosterQueue(Chapter chapterRm, Chapter chapterTlou) {
        this.returnChapterToQueue(chapterRm, this.queueRmBooster);
        this.returnChapterToQueue(chapterTlou, this.queueTlouBooster);
    }

    private void returnChapterToQueue(Chapter chapter, Queue queueBooster) {
        queueBooster.enqueue(chapter);
    }

    public void returnChaptersToQueue(Chapter chapterRm, Chapter chapterTlou) {
        this.returnChapterToQueue(chapterRm, this.queueRm1, this.queueRm2, this.queueRm3);
        this.returnChapterToQueue(chapterTlou, this.queueTlou1, this.queueTlou2, this.queueTlou3);
    }

    private void returnChapterToQueue(Chapter chapter, Queue queue1, Queue queue2, Queue queue3) {
        int priority = chapter.getPcb().getPriorityLevel();

        if (priority == 1) {
            queue1.enqueue(chapter);
        }
        if (priority == 2) {
            queue2.enqueue(chapter);
        }
        if (priority == 3) {
            queue3.enqueue(chapter);
        }
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
