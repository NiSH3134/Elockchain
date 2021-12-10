<%-- 
    Document   : preview
    Created on : 10 Dec, 2021, 4:24:00 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="db.database"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.election"%>
<%@page import="beans.election"%>
<%@page import="db.election_create"%>
<%@page import="db.election_create"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/try.css">
    <link rel="stylesheet" href="../css/top.css">
    <link rel="stylesheet" href="../css/login.css">
    </head>
    <body>
        <div class="wrapper">
        <div class="navbar">
            <div class="navcontainer">
                <img src="../images/l.png" alt="" width="300px">
               <%database d=new database(); HttpSession id=request.getSession(false);%>
                    <ul> 
                        <li class="">Hello,  <%=d.getHostName((String)id.getAttribute("hid"))%></li>
                    <li class="active">Home</li>
                    <li class="active">About</li>
                    <li class="active"><a href="../index.jsp?s=loginpage">Logout</a></li>
                </ul>
            </div>
        </div>

        <div class="socialicons">
            <a href="" class="icon">Basic</a>
            <a href="" class="icon">Candidate</a>
            <a href="" class="icon">Voter</a>
            <a href="#" class="icon">Preview</a>
            <a href="#" class="icon">Finish</a>
        </div>
            
        <table class="box">
            <%
                election_create obj=new election_create();
                
                String input=obj.getElectionLogo((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
                String token="/images";
                String result = input.contains(token) ? token + StringUtils.substringAfter(input, token) : input;
                String r2="http://localhost:41886/Elockchain"+result;
            %>
                    <tr>
                        <center>
                            <td>
                                <img src="<%=r2%>"  width="200px">
                                <%=r2%>
                                <%
//                                    if(request.getParameterMap().containsKey("st"))
//                                    {
//                                        if(request.getParameter("st").equals("1"))
//                                    {
//                                        response.sendRedirect("newjsp.jsp?path="+r2+"");
//                                    }
//                                    }
                                %>
                            </td>
                            <td>
                                <h1><%=obj.getElectionName((String)id.getAttribute("hid"), (String)id.getAttribute("eid"))%></h1>
                            </td>
                            <td>
                                <h1><%=(String)id.getAttribute("eid")%></h1>
                            </td>
                        </center>
                    </tr>
                </table>    
        <table class="box2" id="block7">
            <tr>
                <td width="33%">
                    <h3 style="color: blue;">Candidate ID</h3>
                </td>
                <td width="33%">
                    <h3 style="color: blue;">Candidate Name</h3>
                </td>
                <td width="33%">
                    <h3 style="color: blue;">Candidate Description</h3>
                </td>
            </tr>
             <%
                    
                    ArrayList<election> a=obj.getCandidate((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
                    election b=null;
                    for(int i=0;i<a.size();i++)
                    {
                        b=(election)a.get(i);
                        
                        %>
                        <tr>
                            <td width="33%"><h4><%out.println(b.getCid());%></h4></td>
                            <td width="33%"><h4><%out.println(b.getNameC());%></h4></td>
                            <td width="33%"><h4><%out.println(b.getDesC());%></h4></td>
                            
                        </tr>
                        <%
                    }
                    b=null;
                %>
            <tr>
                <td></td>
                <td><a href="create_election.jsp?st=candidate" style="text-decoration: none;"><button class="btn2">Edit Candidate</button></a></td>
                <td></td>
            </tr>
        </table>
        
        <table class="box2" id="block6">
            <tr>
                <td width="11%">
                    <h3 style="color: blue;">Voter ID</h3>
                </td>
                <td width="25%">
                    <h3 style="color: blue;">Voter Name</h3>
                </td>
                <td width="32%">
                    <h3 style="color: blue;">Voter Email</h3>
                </td>
                <td width="26%">
                    <h3 style="color: blue;">Voter Verification Type</h3>
                </td>
            </tr>
            <%
                    election_create obj2=new election_create();
                    
                    ArrayList<election> c=obj2.getVoter((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
                    b=null;
                    for(int i=0;i<c.size();i++)
                    {
                        b=(election)c.get(i);
                        
                        %>
                        <tr>
                            <td width="11%"><h4><%out.println(b.getVid());%></h4></td>
                            <td width="25%"><h4><center><%out.println(b.getNameV());%></center></h4></td>
                            <td width="32%"><h4><%out.println(b.getEmailV());%></h4></td>
                            <td width="26%"><h4><center><%out.println(b.getvT());%></center></h4></td>
                        </tr>
                        <%
                    }
                    b=null;
                %>
            <tr>
                <td></td>
                <td></td>
                <td><a href="create_election.jsp?st=voter" style="text-decoration: none;"><button class="btn2" style="width:90%;">Edit Voter</button></a></td>
                <td></td>
            </tr>
        </table>
    </div>
            <form action="../createES4" method="post">
                <a href="finish.jsp" style="text-decoration: none;"><button class="btn2" style="width:90%;">Finish Creation</button></a></form>
    </body>
</html>
