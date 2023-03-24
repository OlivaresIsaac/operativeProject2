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
public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public void enqueue(Chapter element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setFirst(node);
            setLast(node);
        } else {
            node.setNext(getLast());
            setLast(node);
        }

        this.length++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            if (getLength() == 1) {
                setFirst(null);
                setLast(null);
            } else {
                Node pointer = getLast();
                while (pointer.getNext() != getFirst()) {
                    pointer = pointer.getNext();
                }
                pointer.setNext(null);
                setFirst(pointer);
            }

            this.length--;
        }
    }
    
     public void dequeueByChapterId(String completeId) {
        if (!isEmpty()) {
            if (getLength() == 1) {
                setFirst(null);
                setLast(null);
            } else {
                Node pointer = getLast();
                
                if (pointer.getElement().getPcb().getCompleteId() == completeId) {
                    setLast(pointer.getNext());
                } else {
                    while (pointer.getNext().getElement().getPcb().getCompleteId() != completeId) {
                        pointer = pointer.getNext();
                }
                     if (pointer.getNext() == getFirst()) {
                     setFirst(pointer);
                } else {
                      pointer.setNext(pointer.getNext().getNext());
                }
                
                }

                
               
              
               
            }

            this.length--;
        }
    }
    
    public Chapter dispatch(){
        Chapter element = process();
        dequeue();
        return element;
    }
    
    public Chapter process(){
        return getFirst().getElement();
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isEmpty() {
        return getFirst() == null;
    }
    
    public void printElements(){
        Node pointer = getLast();
        while (pointer != null) {
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
    }
    
    public String buildStringForUiQueue(){
        Node pointer = getLast();
        String acc = "";
        while (pointer != null) {
            acc = " "+pointer.getElement().getPcb().getCompleteId() +" "+ acc;
            pointer = pointer.getNext();
        }
        return acc;
    }
}