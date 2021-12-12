<%-- 
    Document   : view_election
    Created on : 12 Dec, 2021, 10:17:32 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="db.blocks"%>
<%@page import="db.database"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="db.election_create"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.election"%>
<%@page import="beans.election"%>
<%@page import="beans.election"%>
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
                String eid=obj.getEiDforHiD((String)id.getAttribute("hid"));
                String input=obj.getElectionLogo((String)id.getAttribute("hid"), eid);
                
                    File file =  new File(input);
                    FileInputStream fileInputStreamReader = new FileInputStream(file);
                    byte[] bytes = new byte[(int)file.length()];
                    fileInputStreamReader.read(bytes);
                    String abc=new String(Base64.getEncoder().encode(bytes), "UTF-8");
                    
                
                    String path="data:image/png;base64,"+abc;
            
            %>
                    <tr>
                        <center>
                            <td>
                                <img src="<%=path%>"  width="200px">
                                
                            </td>
                            <td>
                                <h1><%=obj.getElectionName((String)id.getAttribute("hid"), eid)%></h1>
                            </td>
                            <td>
                                <h1><%=eid%></h1>
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
                            <h3 style="color: blue;">Vote Count</h3>
                        </td>
                    </tr>  
                    <%
                    
                    ArrayList<election> a=obj.getCandidate((String)id.getAttribute("hid"), eid);
                    election b=null;
                    blocks boc=new blocks();
                    
                    for(int i=0;i<a.size();i++)
                    {
                        b=(election)a.get(i);
                        
                        %>
                        <tr>
                            <td width="33%"><h4><%out.println(b.getCid());%></h4></td>
                            <td width="33%"><h4><%out.println(b.getNameC());%></h4></td>
                            <td width="33%"><h4><%=boc.getBalance(b.getCid())%></h4></td>
                            
                        </tr>
                        <%
                    }
                    b=null;
                %>
        </div>
    </body>
</html>
