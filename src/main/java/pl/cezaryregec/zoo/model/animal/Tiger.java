package pl.cezaryregec.zoo.model.animal;

import java.time.LocalDate;
import java.util.Calendar;

public class Tiger extends Animal {
    private static final long serialVersionUID = -6868309417903072158L;

    public Tiger(String name, LocalDate birthday) {
        super(name, birthday);
    }

    @Override
    public String toString() {
        return "Tygrys " + super.toString();
    }
}
