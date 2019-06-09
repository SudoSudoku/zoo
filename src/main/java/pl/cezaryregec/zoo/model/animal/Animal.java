package pl.cezaryregec.zoo.model.animal;

import pl.cezaryregec.zoo.model.LivingCreature;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public abstract class Animal implements LivingCreature {
    private static final long serialVersionUID = 5678831852485909559L;

    protected final String name;
    protected final LocalDate birthday;
    protected boolean alive;

    protected Animal(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.alive = true;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return this.name.equals(((Animal) obj).name);
        }

        return false;
    }

    @Override
    public String toString() {
        return name + ", urodzony " + birthday.format(DateTimeFormatter.ISO_DATE) + ", żywy: " + (alive ? "tak" : "nie");
    }
}
