package pl.cezaryregec.zoo.actions.menu;

import pl.cezaryregec.zoo.actions.ZooActionIndex;

import java.util.HashMap;
import java.util.Map;

class MenuDictionary {
    private static final Map<ZooActionIndex, String> DICTIONARY = new HashMap<>();
    static {
        DICTIONARY.put(ZooActionIndex.GET_MENU, "Menu dostępnych opcji");
    }

    private MenuDictionary() {}

    static String get(ZooActionIndex index) {
        return DICTIONARY.get(index);
    }
}
