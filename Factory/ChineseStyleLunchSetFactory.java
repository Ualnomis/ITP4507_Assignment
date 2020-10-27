package Factory;

import LunchSet.ChineseStyleLunchSet;
import LunchSet.LunchSet;

public class ChineseStyleLunchSetFactory extends LunchSetFactory {
    public LunchSet createLunchSet() {
        return new ChineseStyleLunchSet();
    } 
}
