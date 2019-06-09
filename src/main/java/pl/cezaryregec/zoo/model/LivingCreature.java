package pl.cezaryregec.zoo.model;

import java.io.Serializable;
import java.time.LocalDate;

public interface LivingCreature extends Serializable {
    LocalDate getBirthday();
    boolean isAlive();
}
