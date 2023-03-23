/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Random;

/**
 *
 * @author isaac
 */
public final class Chapter {
    private PCB pcb;
    private int duration;
    private String chapterName;
    private int counter;
    
    //studioInitials are rm and tlou lowercase
    public Chapter(int id, String studioInitials) {
        calculateDuration(studioInitials);
        this.pcb = new PCB(id, studioInitials, calculatePriorityLevel());        
        this.counter = 0;
        this.chapterName = ("(V."+id+") "+((studioInitials.equals("rm")) ? ChaptersName.getRmChapterName() : ChaptersName.getTlouChapterName()));
      
       
    }
    
        public Chapter(int id, String studioInitials, String chapterName) {
        calculateDuration(studioInitials);
        this.pcb = new PCB(id, studioInitials, calculatePriorityLevel());        
        this.counter = 0;
        this.chapterName = chapterName;
      
       
    }
    
     /**
     * Calculates the duration of the chapter based on the qty and
     * quality of their chapters parts.
     * @param studioInitials
     */
    public void calculateDuration(String studioInitials){
       int durationAcc = 0;
         //intro
       durationAcc += getPartDuration(1, 1, 76, studioInitials);
        //Inicio
       durationAcc += getPartDuration(2, 2, 85, studioInitials);
       // cierre
       durationAcc += getPartDuration(1, 2, 81, studioInitials);
       // créditos
       durationAcc += getPartDuration(1, 1, 86, studioInitials);
   
       setDuration(durationAcc);
 
    }
    
     /**
     * Calculates the duration of an specific chapter part
     * Quality part = 19 min
     * Non quality part = 3 min
     * @param rmPartQty
     * @param tlouPartQty
     * @param partPercentage
     * @param studioInitials
     * @return part duration in min
     */
     public int getPartDuration(int rmPartQty, int tlouPartQty, int partPercentage, String studioInitials) {
        Random random = new Random();
        int randomInt;
        int acc = 0;
        int partQtyFactor = (studioInitials.equals("rm")) ? rmPartQty : tlouPartQty;
        for (int i = 0; i < partQtyFactor;i++) {
            randomInt = random.nextInt(101);
            if (randomInt < partPercentage) {
                acc += 19;
            } else {
                acc += 3;
            }
        }
        return acc;
     }
    
    
    
     /**
     * Calculates initial priority level based on chapter duration
     * @return Priority level
     */
    public int calculatePriorityLevel(){
        int priorityLevel;
        if (getDuration() > 90) {
            priorityLevel = 1;
        } else if (getDuration() < 60) {
            priorityLevel = 3;
        } else {
            priorityLevel = 2;
        }
        
        return priorityLevel;
    }
    
     /**
     * Updates the chapter counter and updates its priority
     * when reaches 8
     */
    public void updateCounter(){
        if (getCounter() < 7) {
            setCounter(getCounter()+1);
        } else {
            setCounter(0);
            getPcb().promotePriority();
        }
    }

    public PCB getPcb() {
        return pcb;
    }

    public void setPcb(PCB pcb) {
        this.pcb = pcb;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public void printChapterInfo(){

        System.out.println("Capitulo: "+getChapterName()+" Duracion: "+ getDuration()+" idCompleto: "+getPcb().getCompleteId()+ " prioridad: "+getPcb().getPriorityLevel()+"\n");
    }
    
    public String toSaveString(){
        return(getPcb().getNumericId()+","+(getPcb().getStudioInitials().equals("rm") ? "r" : "t")+","+getChapterName()+"\n");
    }
    
    

}
