package Factory;

import LunchSet.LunchSet;
import LunchSet.WesternStyleLunchSet;

public class WesternStyleLunchSetFactory extends LunchSetFactory {
 public LunchSet createLunchSet() {
        return new WesternStyleLunchSet();
    }    
}
