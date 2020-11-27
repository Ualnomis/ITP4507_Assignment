package Factory;

import Menu.ChineseStyleLunchSetMenu;
import Menu.Menu;

public class ChineseStyleLunchSetMenuFactory extends MenuFactory {
    public Menu createMenu() {
        return new ChineseStyleLunchSetMenu();
    }
}
