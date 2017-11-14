package better.panel;

import better.manager.ViewManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard implements ActionListener {

    private ViewManager viewManager;

    private JButton listButton;
    private JButton addEmploye;

    public Dashboard(ViewManager viewManager){

        this.viewManager = viewManager;

        this.viewManager.panel = new JPanel();


        this.addEmploye = new JButton("Ajouter un employé");
        this.addEmploye.addActionListener(this);
        this.listButton = new JButton("Lister les employés");
        this.listButton.addActionListener(this);



        this.viewManager.panel.add(this.addEmploye);
        this.viewManager.panel.add(this.listButton);




    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.listButton){
            System.out.println("list");
            this.viewManager.displayList();
        }

        else if(event.getSource() == this.addEmploye){
            System.out.println("add");
            this.viewManager.displayForm();
        }
    }


}


