package app;

/**
 *
 * @author john
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        
        MainView mainView = new MainView();
        MainCntl mainCntl = new MainCntl(mainView);
    }
}
