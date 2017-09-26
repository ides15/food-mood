package tests;

import app.MainCntl;
import app.MainView;

/**
 *
 * @author john
 */
public class TestHarness {
    public static void main(String[] args) {
        System.out.println("Testing started.");
        MainView mainView = new MainView();
        System.out.println("MainView instantiated.");
        MainCntl mainCntl = new MainCntl(mainView);
    }
}
