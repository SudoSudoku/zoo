package pl.cezaryregec.zoo.repository;

import pl.cezaryregec.zoo.model.animal.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnimalRepository implements Repository<String, Animal> {
    private static final long serialVersionUID = -3004718513968458912L;

    private final List<Animal> repository = Collections.synchronizedList(new ArrayList<>());

    @Override
    public synchronized Animal get(String name) {
        return repository.stream()
                .filter(item -> name.equals(item.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public synchronized List<Animal> get(Predicate<Animal> predicate) {
        return repository.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public synchronized void add(Animal animal) {
        repository.remove(animal);
        repository.add(animal);
    }

    @Override
    public void remove(Animal animal) {
        repository.remove(animal);
    }
}
