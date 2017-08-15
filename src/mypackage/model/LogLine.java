package mypackage.model;

import java.util.HashMap;

/**
 * Created by ASMogilevsky on 28.07.2017.
 */
public class LogLine extends Object{
    public  int countOfRepeat = 1;
    public String stackTrace = "";
    public  String value;     //сама строка (желательно обработанная)
//    public static String keyValue;  //регулярное выражение, которое "нашло" строку

    public LogLine(String value){this.value = value;}

    public void increaseOfCountOfRepeat() {
        countOfRepeat++;
    }



    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getStackTrace(){
        return this.stackTrace;
    }



    @Override
    public String toString() {
        return "Count of repeat:  " + countOfRepeat +"   " + value;
    }

    public static void putInHashMap(String line, HashMap<String, LogLine> hashMap) {
        if (hashMap.containsKey(line)) {
            LogLine logLine = hashMap.get(line);
            logLine.increaseOfCountOfRepeat();
        } else
        {
            LogLine logLine = new LogLine(line);
            hashMap.put(line,logLine);
        }
    }
}
