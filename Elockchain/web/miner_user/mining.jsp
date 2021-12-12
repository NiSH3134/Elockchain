<%-- 
    Document   : mining
    Created on : 12 Dec, 2021, 8:03:59 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="beans.pendingBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.blocks"%>
<%@page import="db.database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/top.css">
        
        <style>
            td{
                padding: 10px;
            }
            .btn {
    display: block;
    width: 70%;
    padding: 15px;
    background-color: rgb(15, 15, 121);
    color: whitesmoke;
    border: none;
    border-radius: 10px;
    font-size: 20px;
    font-weight: 600;
    opacity: 0.8;
    transition: .2s all;
    cursor: pointer;
    
}
        </style>
    </head>
    <body>
    <div class="wrapper">
        <div class="navbar">
            <div class="navcontainer">
                <img src="../images/l.png" alt="" width="300px">
                <ul>
                    <%
                        HttpSession minerD=request.getSession(false);
                        database db=new database();
                        blocks b=new blocks();
                    %>
                    <li class="">Hii <%=db.getMinerName((String)minerD.getAttribute("mid"))%></li>
                    <li class="active"><%=(String)minerD.getAttribute("mid")%></li>
                    <li class="active">Wallet Balance<%=b.getBalance((String)minerD.getAttribute("mid"))%></li>
                    <a href="miner_reg.jsp?s=loginpage" style="text-decoration: none;"><li class="active">Logout</li></a>
                </ul>
            </div>
        </div>
          <center>
            <br><br>
            <%
                if(request.getParameterMap().containsKey("st"))
                {
                    if(request.getParameter("st").equals("1"))
                    {
                        %>
                        <h4>Block Mined Successfully! Reward Credited in your account</h4>
                        <%
                    }
                }
            %>
            <table width="80%" style="text-align: center;border: 10px;" border="1" cellspacing="15">
                <tr >
                    <td>
                        #
                    </td>
                    <td>
                        <b>From</b>
                    </td>
                    <td>
                        <b>To</b>
                    </td>
                    <td>
                        <b>Timestamp</b>
                    </td>
                    <td>
                        <b>Amount</b>
                    </td>
                    <td>
                        <b>Start Mining</b>
                    </td>
                </tr>
                <%
                    
                    ArrayList<pendingBean> arr=b.getPendingTransaction();
                    int j=0;
                    if(arr.size()==0)
                    {
                        %>
                        <tr><Td colspan="6">No Pending Blocks</Td></tr>
                        <%
                    }
                    for(int i=0;i<arr.size();i++)
                    {
                        pendingBean pb=(pendingBean)arr.get(i);           
                        
                %>
                <tr>
                    <td>
                        <%=i%>
                    </td>
                    <td>
                        <b><%=pb.getFrom()%></b>
                    </td>
                    <td>
                        <b><%=pb.getTo()%></b>
                    </td>
                    <td>
                        <b><%=pb.getTime()%></b>
                    </td>
                    <td>
                        <b><%=pb.getAmount()%></b>
                    </td>
                    <td>
                        <a href="mined.jsp?from=<%=pb.getFrom()%>&to=<%=pb.getTo()%>&time=<%=pb.getTime()%>&amt=<%=pb.getAmount()%>"<button class="btn">Start Mining</button>
                    </td>
                    <%
                        }
                    %>
                </tr>
            </table>
        </center>
    </div> 
    </body>
</html>
