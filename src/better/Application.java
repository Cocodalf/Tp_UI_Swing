package better;


import better.window.Window;
import better.manager.ViewManager;

public class Application {

    public static void main(String[] args) {

        Window window = new Window();
        ViewManager viewManager = new ViewManager(window);


        viewManager.displayDashboard();



    }
}
