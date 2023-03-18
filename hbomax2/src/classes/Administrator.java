/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.dataStructures.Queue;
import ui.GlobalUI;
import ui.UiQueue;

/**
 *
 * @author isaac
 */
public class Administrator {
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
    
    
    
    public Administrator(){
        createQueues();
    }
    
     /**
     * Creates all priority queues and gets the reference
     * of all uiQueues
     */
    private void createQueues(){
        uiQueueRm1 = GlobalUI.getMainPage().getUiQueueRm1();
        queueRm1 = new Queue();
        
        uiQueueRm2 = GlobalUI.getMainPage().getUiQueueRm2();
        queueRm2 = new Queue();
        
        uiQueueRm3 = GlobalUI.getMainPage().getUiQueueRm3();
        queueRm3 = new Queue();
        
        uiQueueRmBooster = GlobalUI.getMainPage().getUiQueueRmBooster();
        queueRmBooster = new Queue();
        
        uiQueueTlou1 = GlobalUI.getMainPage().getUiQueueTlou1();
        queueTlou1 = new Queue();
        
        uiQueueTlou2 = GlobalUI.getMainPage().getUiQueueTlou2();
        queueTlou2 = new Queue();
        
        uiQueueTlou3 = GlobalUI.getMainPage().getUiQueueTlou3();
        queueTlou3 = new Queue();
        
        uiQueueTlouBooster = GlobalUI.getMainPage().getUiQueueTlouBooster();
        queueTlouBooster = new Queue();
    }
    
    public void testQueue(){
        for (int i = 0; i<30;i++) {
        Chapter test = new Chapter(i, "tlou");
        queueRm1.enqueue(test);
        }
        uiQueueTlouBooster.updateUiQueue(queueRm1);
        
    }
}
