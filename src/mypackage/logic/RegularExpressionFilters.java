package mypackage.logic;

import mypackage.model.MyDate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ASMogilevsky on 28.07.2017.
 */
public class RegularExpressionFilters {

    public static Boolean DataFilter(MyDate date1, MyDate date2, String line, String regularExp) {
        /**
         * Если date1 or date2 являются null
         * Фильтр "выключается"
         */
        if (date1.thisDateIsNull() || date2.thisDateIsNull()) {
            return true;
        } else {
            /**
             * предположим, что data1 < date2
             *   todo желательно учесть обратное и менять их местами
             */
            if (date2.dateCompare(date1)) {
                Pattern pattern = Pattern.compile(regularExp);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String str = matcher.group();
                    str = str.substring(0, 12);
                    MyDate dataFromLine = new MyDate(str);
                    return (dataFromLine.dateCompare(date1) && date2.dateCompare(dataFromLine));
                }
                return false;
            } else {
                System.out.println("Нарушен порядок дат");
                return false;
            }
        }
    }

    public static Boolean keyWordFilter(String line, String regularExp){
        Pattern pattern = Pattern.compile(regularExp);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static Boolean ArrayKeyWordFilter (String line, String[] regularExpressions) {
        int count = 0;
        for (String str : regularExpressions) {
            Pattern pattern = Pattern.compile(str);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                count++;
            }
        }
        return  (count == regularExpressions.length);

    }

//    public static String removePartOfLine(String line, String regularExp) {
//        int end ;
//        StringBuilder stringBuilder = new StringBuilder(line);
//
//        Pattern pattern = Pattern.compile(regularExp);
//        Matcher matcher = pattern.matcher(line);
//        if(matcher.find()) {
//            end = matcher.end();
//            line = stringBuilder.substring(end);
//        } else System.out.println("err");
//        return line;
//    }

    public static String removePartLine(String line){
        return line.substring(55);
    }
}
