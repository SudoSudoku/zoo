package pl.cezaryregec.zoo.actions.menu;

import pl.cezaryregec.zoo.actions.ZooActionIndex;

class MenuItemFormatter {
    private MenuItemFormatter() {}

    static String map(ZooActionIndex index) {
        return "[" + index.name() + "] " + MenuDictionary.get(index);
    }
}
