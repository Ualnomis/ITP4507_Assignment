
package Memento;

import java.util.*;
import Menu.*;

public class MenusOriginator {
    private ArrayList<Menu> menus; // store different menu

    public ArrayList<Menu> getMenus() {
        return this.menus;
    }
    public void setMenus(ArrayList<Menu> menus) {
        this.menus = new ArrayList<Menu>(menus);
    }
    public MenusMemento saveToMemento() {
        return new MenusMemento(menus);
    }
    public void restoreFromMemento(MenusMemento m) {
        menus = m.getSavedMenus();
    }

    public static class MenusMemento {
        private final ArrayList<Menu> savedMenus;

        private MenusMemento(ArrayList<Menu> menus) {
            savedMenus = new ArrayList<Menu>();
            for (int i = 0; i < menus.size(); i++) {
                savedMenus.add(menus.get(i).clone());
            }
        }

        private ArrayList<Menu> getSavedMenus() {
            return savedMenus;
        }
    }
}
