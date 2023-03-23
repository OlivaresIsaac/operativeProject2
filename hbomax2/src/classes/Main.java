/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;
import ui.GlobalUI;

/**
 *
 * @author isaac
 */
public class Main {
       public static Semaphore mutex = new Semaphore(1);
       public static Administrator operativeSystem = new Administrator();
       public static ArtificialIntelligence ia = new ArtificialIntelligence();
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GlobalUI.openMainPage();
        FunctionsTXT.resetTXT();
        operativeSystem.startEmulator();
    }
    
}
