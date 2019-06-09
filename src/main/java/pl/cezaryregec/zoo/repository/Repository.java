package pl.cezaryregec.zoo.repository;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

public interface Repository<Id, Model> extends Serializable {
    Model get(Id id);
    List<Model> get(Predicate<Model> predicate);
    void add(Model model);
    void remove(Model model);
}
