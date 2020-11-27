package Factory;

import LunchSet.*;

public class ChineseStyleLunchSetFactory extends LunchSetFactory {
    public LunchSet createLunchSet() {
        return new ChineseStyleLunchSet();
    }
}
