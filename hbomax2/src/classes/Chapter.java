/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author isaac
 */
public final class Chapter {
    private PCB pcb;
    private int duration;
    private String chapterName;
    private int counter;
    
    public Chapter(int id, String studioInitials) {
        this.counter = 0;
        calculateDuration();
        this.pcb = new PCB(id, studioInitials, calculatePriorityLevel());
    }
    
     /**
     * Calculates the duration of the chapter based on the qty and
     * quality of their chapters parts
     */
    public void calculateDuration(){
        setDuration(0);
        //TODO calcular la duracion en base a la cantidad y calidad de
        // partes del capitulo
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
    
    
    
}
