package pl.cezaryregec.zoo.model.animal;

import java.time.LocalDate;
import java.util.Calendar;

public class Elephant extends Animal {
    private static final long serialVersionUID = -1980044156647194615L;

    public Elephant(String name, LocalDate birthday) {
        super(name, birthday);
    }

    @Override
    public String toString() {
        return "Słoń " + super.toString();
    }
}
