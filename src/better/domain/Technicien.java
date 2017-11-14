package better.domain;

public class Technicien extends Employee {

    private final int units;
    private final double UNIT_PRICE = 5;

    public Technicien(String firstname, String lastname, int age, String entryYear, int units) {
        super(firstname, lastname, age, entryYear);
        this.units = units;
    }

    @Override
    public double calculerSalaire() {
        return (double) units * UNIT_PRICE;
    }

    @Override
    public String getPosition() {
        return "Le technicien";
    }
}
