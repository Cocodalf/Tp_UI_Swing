package better.panel;

import better.domain.*;
import better.manager.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmploye implements ActionListener{

    private ViewManager viewManager;
    private JButton returnButton;
    private JButton submit;

    private String[] jobList = {
            "Manutention",
            "Manutention à risque",
            "Production",
            "Production à risque",
            "Représentant"

    };

    private JComboBox <String> comboRole;
    private JTextField firstname;
    private JTextField lastname;
    private JSpinner age;
    private JSpinner year;
    private JSpinner unit;


        public AddEmploye(ViewManager viewManager){

            this.viewManager = viewManager;
            this.viewManager.panel = new JPanel();
            this.comboRole = new JComboBox<>(this.jobList);
            this.firstname = new JTextField();
            this.lastname = new JTextField();
            this.age = new JSpinner();
            this.year = new JSpinner();
            this.unit = new JSpinner();


            this.returnButton = new JButton("Retour ");
            this.returnButton.addActionListener(this);

            this.submit = new JButton("Submit");
            this.submit.addActionListener(this);

            this.viewManager.panel.setLayout(new GridLayout(7,2));


            this.viewManager.panel.add(new JLabel("Roles"));
            this.viewManager.panel.add(this.comboRole);

            this.viewManager.panel.add(new JLabel("Firstname"));
            this.viewManager.panel.add(this.firstname);

            this.viewManager.panel.add(new JLabel("Lastname"));
            this.viewManager.panel.add(this.lastname);

            this.viewManager.panel.add(new JLabel("Age"));
            this.viewManager.panel.add(this.age);

            this.viewManager.panel.add(new JLabel("Entry year"));
            this.viewManager.panel.add(this.year);

            this.viewManager.panel.add(new JLabel("Unité"));
            this.viewManager.panel.add(this.unit);

            this.viewManager.panel.add(this.submit);
            this.viewManager.panel.add(this.returnButton);


        }

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == this.returnButton){
                System.out.println("dashboard");
                this.viewManager.displayDashboard();
            }

            else if(event.getSource() == this.submit){

                String jobs = String.valueOf(this.comboRole.getSelectedItem());
                String nom = this.firstname.getText();
                String prenom = this.lastname.getText();
                int ageEmploye = (int)this.age.getValue();
                String annee = String.valueOf(this.year.getValue());
                int uniteText = (int)this.unit.getValue();

                Employee e;

                switch (jobs){
                    case  ("Manutention"):
                        e = new Manutentionnaire(prenom,nom, ageEmploye, annee,uniteText);
                        break;

                    case  ("Manutention à risque"):
                        e = new ManutARisque(prenom,nom, ageEmploye, annee,uniteText);
                        break;

                    case  ("Production"):
                        e = new Technicien(prenom,nom, ageEmploye, annee,uniteText);
                        break;

                    case  ("Production à risque"):
                        e = new TechnARisque(prenom, nom, ageEmploye, annee,uniteText);
                        break;

                    case  ("Représentant"):
                        e = new Representant(prenom,  nom, ageEmploye, annee, uniteText);
                        break;

                    default:
                        e = null;
                        break;


                }
                if (e != null ){
                    this.viewManager.personnel.ajouterEmploye(e);
                    this.viewManager.displayDashboard();
                }





            }
        }


    }
