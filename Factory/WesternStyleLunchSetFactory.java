package Factory;

import LunchSet.*;

public class WesternStyleLunchSetFactory extends LunchSetFactory {
    public LunchSet createLunchSet() {
        return new WesternStyleLunchSet(); // create western style lunch set
    }
}
