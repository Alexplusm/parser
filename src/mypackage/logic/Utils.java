package mypackage.logic;

/**
 * Created by ASMogilevsky on 09.08.2017.
 */
public class Utils {

    public static int stringToInt(String val, int defaultVal) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}
