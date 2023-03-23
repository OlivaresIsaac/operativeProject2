/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class FunctionsTXT {
    
    public static void saveNewWinner(Chapter winner){
        
        String path = "src\\assets\\winners.txt";
        Chapter[] winners = loadWinners(path, winner);
        int[] points = countPoints(winners);
        int rmPoints = points[0];
        int tlouPoints = points[1];
        String saveString = buildSaveString(winners, rmPoints, tlouPoints);
        
        try {
            PrintWriter pw = new PrintWriter(path);
            pw.print(saveString);
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información");
        }
    }
    
    public static Chapter[] loadWinners(String path, Chapter newWinner){
        Chapter[] winners = new Chapter[100];
        String data = loadTextFromFile(path);
        System.out.println(data);
        String[] dataFragment = data.split("\n");

        
        for (int i = 1; i<dataFragment.length; i++){
            String[] chapterString = dataFragment[i].split(",");
            System.out.println(chapterString[0]);
            int id = Integer.parseInt(chapterString[0]);
           
            String studioInitials = (chapterString[1].equals("r")) ? "rm" : "tlou";
            winners[i] = new Chapter(id, studioInitials, chapterString[2]);
           
        }
        
        winners[dataFragment.length] = newWinner;
        
        return winners;
    }
    
    
       /**
     * Given a path reads a file and converts its content
     * into a string
     * @param direction
     * @return String
 */
    public static String loadTextFromFile(String direction){
        String text = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direction));
            String currentLine;
            while ((currentLine = bf.readLine()) != null) {
               text += (currentLine+"\n");
            }
        } catch (Exception e) {
            text = "";
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }

        return text;
    }
    
    public static int[] countPoints(Chapter[] winners) {
        int[] count = new int[2];
        for (Chapter chapter : winners) {
            if (chapter != null) {
                if (chapter.getPcb().getStudioInitials().equals("rm")) {
                count[0] += 1;
           
            } else {
                count[1] +=1;
            }
            }
            
        }
        return count;
    }
    
    public static String buildSaveString(Chapter[] winners, int rmPoints, int tlouPoints){
        String saveString = "";
        saveString+="rmPoints: "+String.valueOf(rmPoints)+", tlouPoints: "+ String.valueOf(tlouPoints)+"\n";
        for (Chapter chapter : winners) {
            if (chapter != null) {
                  saveString += chapter.toSaveString();
            }
          
        }
      
        return saveString;
    }
    
    public static void resetTXT (){
        String reset = "";
        String path = "src\\assets\\winners.txt";
       try {
            PrintWriter pw = new PrintWriter(path);
            pw.print(reset);
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información");
        }
    }
}
