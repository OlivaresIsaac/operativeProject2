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
public class PCB {
    private String completeId;
    private int numericId;
    private int priorityLevel;
    private String studioInitials;

    public PCB(int numericId, String studioInitials, int priorityLevel) {
        this.studioInitials = studioInitials;
        this.numericId = numericId;
        this.priorityLevel = priorityLevel;
        this.completeId = createCompleteId();
    }
    
    
     /**
     * Creates the complete id of the chapter, numeric id + letter of its studio
     * @return Complete id
     */
    private String createCompleteId() {
        String aux = String.valueOf(getNumericId());
        return (aux+getStudioLetterForId());
    }
    
     /**
     * returns the first letter of the studio's initials
     * @return char
     */
    private char getStudioLetterForId(){
        return this.studioInitials.charAt(0);
        
    }

    public String getCompleteId() {
        return completeId;
    }

    public void setCompleteId(String completeId) {
        this.completeId = completeId;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getNumericId() {
        return numericId;
    }

    public void setNumericId(int numericId) {
        this.numericId = numericId;
    }

    public String getStudioInitials() {
        return studioInitials;
    }

    public void setStudioInitials(String studioInitials) {
        this.studioInitials = studioInitials;
    }
    
    public void promotePriority(){
        setPriorityLevel(getPriorityLevel()+1);
    }
    
    
    
    
    
}
