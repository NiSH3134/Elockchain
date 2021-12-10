<%-- 
    Document   : home
    Created on : 7 Dec, 2021, 7:58:32 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="db.database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Host Home Page</title>
    <link rel="stylesheet" href="../css/top.css">
    <link rel="stylesheet" href="../css/host_home.css">
    <style>
        body {
        background-image: url('../images/chain3.png');
      }
    </style>
    </head>
    
    <body>
    <div>
        <div class="wrapper">
            <div class="navbar">
                <div class="navcontainer">
                    <img src="../images/l.png" alt="" width="300px">
                    <%database d=new database(); HttpSession id=request.getSession(false);%>
                    <ul> 
                        <li class="">Welcome  <%=d.getHostName((String)id.getAttribute("hid"))%></li>
                        <li class="active">About</li>
                        <li class="active"><a href="../index.jsp?s=loginpage">Logout</a></li>
                    </ul>
                </div>
            </div>
            <div class="socialicons">
                <a href="create_election.jsp?st=basic" class="icon" style="background-color: orange;text-decoration: none;">
                     <h1>Create Election</h1>
                </a>
                <a href="#" class="icon" style="background-color: red;">
                    <h1>View Current Election</h1>
                </a>
                <a href="#" class="icon" style="background-color: blue;">
                    <h1>View election History</h1>
                </a>
                
            </div>
        </div>
    </div>
</body>
</html>
