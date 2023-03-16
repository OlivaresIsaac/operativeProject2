/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author isaac
 */
public class GlobalUI {
    private static final MainPage mainPage = new MainPage();

    public static MainPage getMainPage() {
        return mainPage;
    }
        /**
     * Opens project MainPage
     */
    public static void openMainPage() {
        getMainPage().setVisible(true);
        
    }
}
