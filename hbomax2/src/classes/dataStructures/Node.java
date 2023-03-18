/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.dataStructures;

import classes.Chapter;

/**
 *
 * @author isaac
 */
public class Node {
    private Chapter element;
    private Node next;

    public Node(Chapter element) {
        this.element = element;
        this.next = null;
    }

    public Chapter getElement() {
        return element;
    }

    public void setElement(Chapter element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    
    
    
}
