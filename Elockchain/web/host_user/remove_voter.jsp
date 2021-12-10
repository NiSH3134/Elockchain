<%-- 
    Document   : remove_voter
    Created on : 10 Dec, 2021, 3:38:06 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="db.election_create"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            String vid=(String)request.getParameter("vid");
            HttpSession id=request.getSession(false);
            out.println(id.getAttribute("hid")+" "+id.getAttribute("eid"));
            election_create obj=new election_create();
            int r=obj.removeVoter((String)id.getAttribute("hid"), (String)id.getAttribute("eid"), vid);
            if(r>0)
            {
                response.sendRedirect("create_election.jsp?st=voter");
            }
            else
            {
                out.println("Error in removing candidate");
            }
        %>
    </body>
</html>
