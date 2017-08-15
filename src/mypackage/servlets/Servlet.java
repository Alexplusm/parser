package mypackage.servlets;

import com.sun.org.apache.regexp.internal.RE;
import mypackage.logic.ReadFileByLine;
import mypackage.model.LogLine;
import mypackage.model.MyDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static mypackage.logic.Utils.stringToInt;

/**
 * Created by ASMogilevsky on 03.08.2017.
 */


public class Servlet extends HttpServlet
{

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String path = request.getParameter("path");

        String dateStr1 = request.getParameter("date1");
        String dateStr2 = request.getParameter("date2");
        MyDate date1 = new MyDate(dateStr1);
        MyDate date2 = new MyDate(dateStr2);

        String regExp1 = request.getParameter("regExp1");
        String regExp2 = request.getParameter("regExp2");
        String regExp3 = request.getParameter("regExp3");
        String regExp4 = request.getParameter("regExp4");
        String regExp5 = request.getParameter("regExp5");
        String[] regularExpressions = new String[] {regExp1, regExp2, regExp3, regExp4, regExp5};

        String minCountStr = request.getParameter("count");
        int minCount = stringToInt(minCountStr, 1);
        
        ReadFileByLine rf = new ReadFileByLine();
        rf.ReadFile(path, date1, date2, regularExpressions);
        rf.ShowResults();

        HashMap<String,LogLine> hashMap = rf.returnHashMap();

//        for (String key : hashMap.keySet()) {
//            LogLine logLine = hashMap.get(key);
//            /**
//             * minCount
//             */
//            if (logLine.countOfRepeat >= minCount) {
//                response.getWriter().println(logLine.toString());
//                response.getWriter().println();
//            }
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//        }


        /**
         *
         *
         *
         *
         *
         *
         */

        request.setAttribute("map", hashMap);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }

}
