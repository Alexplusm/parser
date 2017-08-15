package mypackage;

import mypackage.logic.ReadFileByLine;
import mypackage.model.MyDate;

public class Test {
    public static void main(String[] args) {

        String path = "/Users/mac/myProjects/green2/log.txt";

        MyDate d1 = new MyDate("00:00:09,701");
        MyDate d2 = new MyDate("");

        //ru.atconsulting.ftl.FtlServlet"

        String[] regularExpressions = new String[]{"ru.atconsulting.ftl.FtlServlet"};
//        regularExpressions[0] = "ru.atconsulting.ftl.FtlServlet";


        ReadFileByLine rf = new ReadFileByLine();
        rf.ReadFile(path, d1, d2, regularExpressions);
        rf.ShowResults();



    }
}

//("00:00:09,701");
//("06:00:10,701");

//FILE_PATH C:\\alexfiles\\myProjects\\exampleFile\\shark.txt

///Users/mac/myProjects/green2/log.log

//  /Users/mac/Desktop/lo