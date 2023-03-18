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
public class ChaptersName {
    
    public static String[] rmChaptersName = new String[] {
        "Pilot rm","Lawnmower Dog", "Anatomy Park", "M. Night Shaym-Aliens!", 
        "Meeseeks and Destroy", "Rick Potion #9","Raising Gazorpazorp",	"Rixty Minutes"
            ,	"Something Ricked This Way Comes", "Close Rick-counters of the Rick Kind", "Ricksy Business"
    };
    
    public static String[] tlouChaptersName = new String[] {
        "Pilot tlou","The Prologue and the Quarantine Zone", "The Outskirts", "Bill's Town", 
        "Pittsburgh", "The Suburbs","Tommy's Dam","The University"
            ,	"Lakeside Resort", "Bus Depot", "The Firefly Lab and Jackson"
    };
    
    public static Random random = new Random();
    
    public static String getRmChapterName(){
        int index = random.nextInt(11);
        return rmChaptersName[index];
    }
    
    public static String getTlouChapterName(){
        int index = random.nextInt(11);
        return tlouChaptersName[index];
    }
}
