<%-- 
    Document   : newjsp
    Created on : 1 Oct, 2021, 5:10:03 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ELOCKCHAIN Log in and Sign Up</title>
        <script>
        function switchd(d)
            {
                var e1=d+'2';
                var e2=d+'1';
                if(document.getElementById(e1).style.display == 'block')
                {
                    document.getElementById(e1).style.display='none';
                    document.getElementById(e2).style.display='block';
                }
                else
                {
                    document.getElementById(e2).style.display='none';
                    document.getElementById(e1).style.display='block';
                }
            }
            </script>
    </head>
    <body>
        <div id="d1" style="display: block;">
            <div id="hello"></div>
            <button onclick="switchd('d')">Login Instead</button>
        </div>
         <div id="d2" style="display: none;">
            <h1>login </h1>
            <button onclick="switchd('d')">SignUp Instead</button>
        </div>
    </body>
</html>
