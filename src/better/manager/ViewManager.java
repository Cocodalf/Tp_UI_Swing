package better.manager;

import better.panel.Dashboard;
import javax.swing.*;

import better.panel.ListEmploye;
import better.panel.AddEmploye;
import better.service.Personnel;
import better.window.Window;

import java.awt.*;

public class ViewManager {

    private Window window;
    private Dashboard dashboard;
    private ListEmploye listEmploye;
    private AddEmploye addEmploye;
    public JPanel panel;
    public Personnel personnel;


    public ViewManager(Window window){

        this.window = window;
        this.personnel = new Personnel();


    }

    public void displayDashboard(){
        this.dashboard = new Dashboard(this);
        this.window.getContentPane().removeAll();
        this.window.setContentPane(this.panel);
        this.window.revalidate();
        this.window.repaint();
    }

    public void displayList(){

        this.window.getContentPane().removeAll();
        this.listEmploye = new ListEmploye(this);
        this.window.setContentPane(this.panel);
        this.window.revalidate();
        this.window.repaint();
    }

    public void displayForm(){
        this.addEmploye = new AddEmploye(this);
        this.window.getContentPane().setLayout(new FlowLayout());
        this.window.getContentPane().add(new JScrollPane());
        this.window.setContentPane(this.panel);
        this.window.setVisible(true);
    }
}
