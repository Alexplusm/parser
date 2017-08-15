package mypackage.logic;

import mypackage.model.LogLine;
import mypackage.model.MyDate;

import java.io.*;
import java.util.HashMap;


import static mypackage.model.LogLine.putInHashMap;
import static mypackage.logic.RegularExpressionFilters.*;


/**
 * Created by ASMogilevsky on 28.07.2017.
 */
public class ReadFileByLine {

    public static final String REG_TIME = "\\d{2}:\\d{2}:\\d{2},\\d{3} ";

    // String - обрабатанная строка
    // LogLine - объект строки из логфайла, хранящий саму строку и количество ее повторений
    private HashMap<String, LogLine> hashMap = new HashMap<>();

    public void ReadFile(String path, MyDate data1, MyDate data2, String[] regularExpressions) {
        try {
            /**
             * Чтение файла по одной строке
             */
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            /**
             * Обработка строки 'line' фильтрами
             * Добавлние строки в hashMap
             */
            while (line != null) {
                if (
                        ArrayKeyWordFilter(line, regularExpressions)
                        && DataFilter(data1, data2, line, REG_TIME)
                        && keyWordFilter(line, REG_TIME)

                   ) {
                    line = removePartLine(line);
                    putInHashMap(line, hashMap);
                    }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowResults() {
        for (String key : hashMap.keySet()) {
            LogLine logLine = hashMap.get(key);
            System.out.println(logLine.toString());
        }
    }

    public  HashMap<String,LogLine> returnHashMap() {
        return hashMap;
    }
}