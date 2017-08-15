<%@ page import="java.util.HashMap" %>
<%@ page import="mypackage.model.LogLine" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
      <title>Results</title>
      <link rel="stylesheet" type="text/css" href="styles.css">
      <script type="text/javascript" src="jQuery.js"></script>
  </head>
  <body>

<div id="abc">

  <%
    @SuppressWarnings("unchecked") HashMap<String, LogLine> hashMap = (HashMap<String, LogLine>) request.getAttribute("map");

    long i = 0;
    for (String key : hashMap.keySet()) {

      LogLine logLine = hashMap.get(key);
      out.print("<div id=\"div" + i % 2 + "\"class=\"someDiv\">");
      out.print(logLine.toString());
      out.print("</div>");

      out.print("<div id=\"" + i + "\"class=\"buttonclick\">show results</div>");
      out.print("<div id=\"menu" + i +"\"class=\"menuclick\">меню</div>");

      i++;
    }
  %>


    <script>
        $(document).ready(function(){
            $('.buttonclick').click(function() {
                var id = $(this).attr('id')
                $("#menu" + id).toggle();
                console.log($(this).attr('id'));
            });
        });
    </script>

</div>

  </body>
</html>