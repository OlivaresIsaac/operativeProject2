/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.dataStructures.Node;
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
            // try to return booster chapter
            this.tryToReturnBoosterChapter(this.queueRmBooster, this.queueRm1, this.queueRm2, this.queueRm3);
            this.tryToReturnBoosterChapter(this.queueTlouBooster, this.queueTlou1, this.queueTlou2, this.queueTlou3);

            if (this.counter >= 2) {
                // add a new chapter to some list
                this.addNewChapter();
                // reset administrator's counter
                this.setCounter(0);
            }

            // get chapters
            Chapter chapterRm = this.getChapterFromQueues(this.queueRm1, this.queueRm2, this.queueRm3);
            Chapter chapterTlou = this.getChapterFromQueues(this.queueTlou1, this.queueTlou2, this.queueTlou3);
            
            // set chapters to IA
            ia.setChapterRm(chapterRm);
            ia.setChapterTlou(chapterTlou);

            // init IA
            ia.start();
            
            // add one to chapter counters
            this.addOneToCounter(queueRm2);
            this.addOneToCounter(queueRm3);
            this.addOneToCounter(queueTlou2);
            this.addOneToCounter(queueTlou3);
            
            // TODO: reset selected chapter's counter
            // chapterRm.setCounter(0);
            // chapterTlou.setCounter(0);
            
            // add one to administrator's counter
            this.setCounter(this.counter + 1);
        }
    }

    //TODO
    private void addNewChapter() {
        int result = r.nextInt(100);
        if (result <= 70) {
            // TODO: add a new series to the queue of its corresponding level
        }
    }

    private void addOneToCounter(Queue queue) {
        Node pointer = queue.getLast();
        while (pointer != null) {
            // add 1 to the counter
            Chapter chapter = pointer.getElement();
            chapter.setCounter(chapter.getCounter() + 1);

            // if the counter is greater equal to 8 then move up priority
            if (chapter.getCounter() >= 8) {
                PCB pcb = chapter.getPcb();
                // if priority is greater than 1
                if (pcb.getPriorityLevel() > 1) {
                    pcb.setPriorityLevel(pcb.getPriorityLevel() - 1);
                }
                chapter.setCounter(0);
            }

            pointer = pointer.getNext();
        }
    }

    private void tryToReturnBoosterChapter(Queue booster, Queue queue1, Queue queue2, Queue queue3) {
        if (booster.isEmpty()) {
            return;
        }

        int result = r.nextInt(100);
        if (result <= 40) {
            Chapter chapter = booster.dispatch();
            chapter.getPcb().setPriorityLevel(1);
            this.returnChapterToQueue(chapter, queue1, queue2, queue3);
        } else {
            Chapter chapter = booster.dispatch();
            booster.enqueue(chapter);
        }
    }

    private Chapter getChapterFromQueues(Queue queue1, Queue queue2, Queue queue3) {
        if (!queue1.isEmpty()) {
            return queue1.dispatch();
        } else if (!queue2.isEmpty()) {
            return queue2.dispatch();
        } else if (!queue3.isEmpty()) {
            return queue3.dispatch();
        }
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
        // TODO: Save Chapter To Txt
    }

    public void sendChaptersToBoosterQueue(Chapter chapterRm, Chapter chapterTlou) {
        this.returnChapterToQueue(chapterRm, this.queueRmBooster);
        this.returnChapterToQueue(chapterTlou, this.queueTlouBooster);
    }

    public void returnChaptersToQueue(Chapter chapterRm, Chapter chapterTlou) {
        this.returnChapterToQueue(chapterRm, this.queueRm1, this.queueRm2, this.queueRm3);
        this.returnChapterToQueue(chapterTlou, this.queueTlou1, this.queueTlou2, this.queueTlou3);
    }

    private void returnChapterToQueue(Chapter chapter, Queue queueBooster) {
        queueBooster.enqueue(chapter);
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
