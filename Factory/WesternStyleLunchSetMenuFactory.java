package Factory;

import Menu.Menu;
import Menu.WesternStyleLunchSetMenu;

public class WesternStyleLunchSetMenuFactory extends MenuFactory {
   public Menu createMenu() {
        return new WesternStyleLunchSetMenu();
    }
}
