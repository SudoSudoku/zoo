package pl.cezaryregec.zoo.model.animal;

import java.time.LocalDate;
import java.util.Calendar;

public class Giraffe extends Animal {
    private static final long serialVersionUID = 5966576888274965455L;

    public Giraffe(String name, LocalDate birthday) {
        super(name, birthday);
    }

    @Override
    public String toString() {
        return "Żyrafa " + super.toString();
    }
}
