package better.panel;

import better.manager.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import better.domain.Employee;

public class ListEmploye implements ActionListener{

    private ViewManager viewManager;

    private JButton returnButton;
    private JButton addEmploye;

    public ListEmploye(ViewManager viewManager){

        this.viewManager = viewManager;
        this.viewManager.panel = new JPanel(new BorderLayout());

        ArrayList <Employee> listEmployee = this.viewManager.personnel.getEmployees();

        Object[][] data = new Object[listEmployee.size()+2][];

        int i = 0 ;
        int total =0;
        for (Employee e : listEmployee){
            data[i]= (new Object[]{
                    e.getPosition(),
                    e.getName(),
                    e.getAge(),
                    e.getEntryYear(),
                    e.calculerSalaire()
            }); i++;
            total += e.calculerSalaire();
        }

        data[i] = new Object[]{"Salaire moyen", "", "", "", this.viewManager.personnel.salaireMoyen()};
        i++;
        data[i] = new Object[]{"Total salaires", "", "", "", total};
        String[] entetes = {"Metiers", "Employe", "Age", "Année d'entrée", "Salaire"};
        JTable table = new JTable( data, entetes);



        this.returnButton = new JButton("Retour ");
        this.returnButton.addActionListener(this);

        this.addEmploye = new JButton("Ajouter un employé");
        this.addEmploye.addActionListener(this);

        this.viewManager.panel.add(table.getTableHeader(),BorderLayout.NORTH);
        this.viewManager.panel.add(table, BorderLayout.CENTER);


        this.viewManager.panel.add(this.addEmploye, BorderLayout.SOUTH);
        this.viewManager.panel.add(this.returnButton, BorderLayout.SOUTH);





    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.returnButton){
            System.out.println("list");
            this.viewManager.displayDashboard();
        }

        else if(event.getSource() == this.addEmploye){
            System.out.println("add");
            this.viewManager.displayForm();
        }
    }


}


