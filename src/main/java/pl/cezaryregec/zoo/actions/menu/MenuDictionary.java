package pl.cezaryregec.zoo.actions.menu;

import pl.cezaryregec.zoo.actions.ZooActionIndex;

import java.util.HashMap;
import java.util.Map;

class MenuDictionary {
    private static final Map<ZooActionIndex, String> DICTIONARY = new HashMap<>();
    static {
        DICTIONARY.put(ZooActionIndex.GET_MENU, "Menu dostępnych opcji");
        DICTIONARY.put(ZooActionIndex.ADD_ANIMAL, "Dodaj zwierzę");
        DICTIONARY.put(ZooActionIndex.GET_ANIMALS, "Wyświetl zwierzęta w ZOO");
        DICTIONARY.put(ZooActionIndex.GET_ANIMALS_BY_TYPE, "Wyświetl zwierzęta w ZOO filtrując po typie");
        DICTIONARY.put(ZooActionIndex.REMOVE_ANIMAL, "Usuń zwierzę");
        DICTIONARY.put(ZooActionIndex.SHUTDOWN, "Zakończ program");
    }

    private MenuDictionary() {}

    static String get(ZooActionIndex index) {
        return DICTIONARY.get(index);
    }
}
