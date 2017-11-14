package better.service;

import better.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class Personnel {

    private ArrayList<Employee> employees;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";

    public Personnel() {
        this.employees = new ArrayList<>();
    }

    public void ajouterEmploye(Employee employee) {
        this.employees.add(employee);
    }

    public void afficherSalaires() {
        employees.forEach(employee -> System.out.println(String.format(PRINT_PATTERN, employee.getName(), employee.calculerSalaire())));
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public double salaireMoyen() {
        double total = 0;
        for (Employee employee: employees) {
            total += employee.calculerSalaire();
        }
        return total / employees.size();
    }

    public void afficherNoms(){
        employees.forEach(employee -> System.out.println(String.format(PRINT_PATTERN, employee.getName())));
    }


}
